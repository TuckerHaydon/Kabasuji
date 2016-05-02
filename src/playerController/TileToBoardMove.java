package playerController;

import java.util.Random;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.PuzzleLevelView;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.GameModel;
import playerEntity.LevelAchievementMonitor;
import playerEntity.LightningLevel;
import playerEntity.PlayableBoardElt;
import playerEntity.PuzzleLevel;
import playerEntity.Square;
import playerEntity.Tile;

/**
 * Adds a Tile to the board
 * setting the dragged TileView to null 
 * In the case of a Lightning Level, a valid move 
 * adds a random Tile to the Bullpen, and an invalid one
 * adds the Tile being moved by the player back.
 * @author tuckerhaydon, 
 * @author dgwalder
 * @author jwilder
 * @author kacper puczydlowski
 *
 */
public class TileToBoardMove extends Move{
	int row;
	int col;
	Board board;
	Tile tile;
	LevelAchievementMonitor AM;
	
	/**
	 * Tile To Board Move constructor
	 * @param app application
	 * @param m model
	 * @param b board
	 * @param tile tile
	 * @param row
	 * @param col
	 */
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
			if(AM.updateAchievement_wheninvalidmove()){
				AM.popUpScreen();
			}
			
			return false;
		}
		
		return this.doMove();
		
	}
	
	/**
	 * Checks to see where the tile has been placed on the board and 
	 * if it is a valid move for the level, the tile is placed.
	 * If not, the tile is kept in possession (attached to the mouse) until the 
	 * player makes a valid move.
	 * 
	 */
	@Override
	boolean doMove() {
		
		// Set the location of the anchor
		tile.getAnchor().setRowCol(row, col);
		
		// Add the tile to the board
		board.addTile(tile,row, col);
		// Release the dragged tile
		app.getGameWindow().releaseDraggedTile();
				
		//update lightning level moves
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
			((PuzzleLevelView) app.getGameWindow().getLevelView()).refreshMoveLabel();
		}
		
		tile.setLocation("board");
		
		if(AM.updateAchievement_releaseonboard()){
			AM.popUpScreen();
		}
		
		//refresh progress bar
		app.getGameWindow().getLevelView().refreshProgressBar();
		
		//if level is completed, complete to main button appears
		if((m.getCurrentLevel().getStars()>=1)){
			app.getGameWindow().getLevelView().competeLevelButton();
		}
		
		// Update the GUI
		app.getGameWindow().getLevelView().getBoardView().repaint();
		app.getGameWindow().getLevelView().repaint();
		
		// Check to see if the level has won
		CompleteLevelMove move = new CompleteLevelMove(app, m);
		move.execute();
		
		return true;
	}

	/**
	 * Checks conditions of validity for move.
	 */
	@Override
	boolean isValid() {

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
				if(playableElt.getCovered() && !(m.getCurrentLevel() instanceof LightningLevel)){
					//System.err.println("TTBM:isValid(): trying to cover a covered elt.");
					return false;
				}
			} 
			// If it is not a playable elt, the move is not valid
			else {
				//System.err.println("TTBM:isValid(): trying to cover an unplayable elt.");
				return false;
			}
		}
		
		return true;
	}

	@Override
	boolean undo() {
		if(m.getCurrentLevel() instanceof LightningLevel) {
			return false;
		}
		board.removeTile(tile);
		m.getCurrentLevel().getBullpen().addTile(tile);
//		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}
	
	public void setAM(LevelAchievementMonitor lam){
		this.AM = lam;
	}

}
