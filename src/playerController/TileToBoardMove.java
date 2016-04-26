package playerController;

import java.util.ArrayList;
import java.util.Random;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.PuzzleLevelView;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.GameModel;
import playerEntity.LevelAchievementMonitor;
import playerEntity.LightningLevel;
import playerEntity.PlayableBoardElt;
import playerEntity.PuzzleLevel;
import playerEntity.Square;
import playerEntity.Tile;
import playerEntity.UnplayableBoardElt;

/**
 * 
 * @author tuckerhaydon, dgwalder
 *
 */
public class TileToBoardMove extends Move{
	int row;
	int col;
	Board board;
	Tile tile;
	LevelAchievementMonitor AM;
	
	public TileToBoardMove(KabasujiPlayerApplication app, GameModel m, Board b, Tile tile, int row, int col){
		super(app, m);
		this.row=row;
		this.col=col;
		this.tile = tile;
		this.board=b;
	}
	
	@Override
	public boolean execute(){
		
		AM = m.getCurrentAM();
		
		// Validate the move
		if(!this.isValid()) {
			if(m.getCurrentLevel() instanceof LightningLevel){
				Random r = new Random();
				int randIndex = r.nextInt(35 - 1) + 1;
				Tile t = new Tile(randIndex, "bullpen");
				m.getCurrentLevel().getBullpen().addTile(t);
				System.out.println("Adding tile "+randIndex+" to bullpen.");
			}
			app.getGameWindow().releaseDraggedTile();
			if(AM.updateAchievement_wheninvalidmove()){
				AM.popUpScreen();
			}
			return false;
		}
		
		return this.doMove();
		
	}
	
	@Override
	public boolean doMove() {
		
		// Set the location of the anchor
		tile.getAnchor().setRowCol(row, col);
		
		// Add the tile to the board
		board.addTile(tile,row, col);
		
		// Release the dragged tile
		app.getGameWindow().releaseDraggedTile();
		if(m.getCurrentLevel() instanceof LightningLevel){
			Random r = new Random();
			int randIndex = r.nextInt(35 - 1) + 1;
			Tile t = new Tile(randIndex, "bullpen");
			m.getCurrentLevel().getBullpen().addTile(t);
			System.out.println("Adding tile "+randIndex+" to bullpen.");
		}
		
		//update puzzle level moves
		if (m.getCurrentLevel() instanceof PuzzleLevel){
			((PuzzleLevel) m.getCurrentLevel()).updateMoves(+1);
			((PuzzleLevelView) app.getGameWindow().getLevelView()).refreshLabels();
		}
		
		if(AM.updateAchievement_releaseonboard()){
			AM.popUpScreen();
		}
		
		// Update the GUI
		app.getGameWindow().getLevelView().getBoardView().repaint();
		
		return true;
	}

	@Override
	boolean isValid() {
		
		
		//times when this move is valid:
		
		//bullpen -> board: any level
		//board -> board: puzzle
		//board-> bullpen: puzzle, release
		//TODO - check when there are moves left: puzzle
		
		
		//check each board element and determine if it is playable
		//if it is, determine if it is covered.
		//return true if all elements are playable and uncovered
		for(Square s : tile.getSquares()) {
			
			// Determine the row, col of a square
			// These are negative because the coordinate systems of the tile and the board are backwards
			int squareRow = row - s.getRelY();
			int squareCol = col + s.getRelX();
			
			// Make sure within bounds
			if(squareCol >=12 || squareRow >= 12 || squareCol < 0 || squareRow < 0){
				return false;
			}
			
			BoardElt elt = board.getBoardElt(squareRow, squareCol);
			
			// Check to make sure the elt is playable
			if(elt instanceof PlayableBoardElt) {
				
				PlayableBoardElt playableElt = (PlayableBoardElt) elt;
				
				// Check to see if the elt is already covered
				if(playableElt.getCovered()){
					System.err.println("TTBM:isValid(): trying to cover a covered elt.");
					return false;
				}
			} 
			// If it is not a playable elt, the move is not valid
			else {
				System.err.println("TTBM:isValid(): trying to cover an unplayable elt.");
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean undo() {
		if(m.getCurrentLevel() instanceof LightningLevel) {
			return false;
		}
		
		
		board.removeTile(tile);
		m.getCurrentLevel().getBullpen().addTile(tile.getReferenceNumber());
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

}
