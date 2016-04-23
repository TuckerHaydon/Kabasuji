package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.LightningLevel;
import playerEntity.PlayableBoardElt;
import playerEntity.Square;
import playerEntity.Tile;
import playerEntity.UnplayableBoardElt;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class TileToBoardMove implements IMove{
	int row;
	int col;
	Board board;
	Tile tile;
	
	public TileToBoardMove(Board b, Tile tile, int row, int col){
		this.row=row;
		this.col=col;
		this.tile = tile;
		this.board=b;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		
		// Validate the move
		if(!this.isValid(app)) {
			return false;
		}

		// Set the location of the anchor
		tile.getAnchor().setRowCol(row, col);
		
		// Add the tile to the board
		board.addTile(tile,row, col);
		
		// Release the dragged tile
		app.getGameWindow().releaseDraggedTile();
		
		// Update the GUI
		app.getGameWindow().getLevelView().getBoardView().repaint();
		
		return true;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		
		//check each board element and determine if it is playable
		//if it is, determine if it is covered.
		//return true if all elements are playable and uncovered
		for(Square s : tile.getSquares()) {
			
			// Determine the row, col of a square
			// These are negative because the coordinate systems of the tile and the board are backwards
			int squareRow = row - s.getRelY();
			int squareCol = col + s.getRelX();
			
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

	public boolean undo(KabasujiPlayerApplication app) {
		if(app.getGameModel().getCurrentLevel() instanceof LightningLevel) {
			return false;
		}
		board.removeTile(tile);
		app.getGameModel().getCurrentLevel().getBullpen().addTile(tile.getReferenceNumber());
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}
}
