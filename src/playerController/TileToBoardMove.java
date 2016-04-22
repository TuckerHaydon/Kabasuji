package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.LightningLevel;
import playerEntity.PlayableBoardElt;
import playerEntity.Square;
import playerEntity.UnplayableBoardElt;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class TileToBoardMove implements IMove{
	int row;
	int col;
	Anchor anchor;
	Board board;
	
	public TileToBoardMove(Board b, Anchor a, int row, int col){
		this.row=row;
		this.col=col;
		this.anchor=a;
		this.board=b;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		
		// Make sure the move is valid
		if(!this.isValid(app)) {
			return false;
		}

		anchor.setRowCol(row, col);
		board.addTile(anchor.getTile(),row, col);
		return true;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		boolean valid = true;
		
		//check each board element and determine if it is playable
		//if it is, determine if it is covered.
		//return true if all elements are playable and uncovered
		for(Square s : anchor.getTile().getSquares()) {
			if(board.getBoardElt(row + s.getRelX(), col + s.getRelY()) instanceof UnplayableBoardElt == false) {
				if(((PlayableBoardElt) board.getBoardElt(row + s.getRelX(), col + s.getRelY())).getCovered()){
					System.err.println("TTBM:isValid(): trying to cover a covered elt.");
					valid = false;
				}
			} else {
				System.err.println("TTBM:isValid(): trying to cover an unplayable elt.");
				valid = false;
			}
		}
		return valid;
	}

	public boolean undo(KabasujiPlayerApplication app) {
		if(app.getGameModel().getCurrentLevel() instanceof LightningLevel) {
			return false;
		}
		board.removeTile(anchor.getTile());
		app.getGameModel().getCurrentLevel().getBullpen().addTile(anchor.getTile().getReferenceNumber());
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}
}
