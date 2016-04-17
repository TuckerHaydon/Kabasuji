package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.PlayableBoardElt;
import playerEntity.Square;
import playerEntity.UnplayableBoardElt;

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
		// TODO Auto-generated method stub
		if(isValid(app)) {
			if(board.addTile(anchor.getTile(),row, col)) return true;
		}
		return false;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		boolean valid = true;
		
		//check each board element and determine if it is playable
		//if it is, determine if it is covered.
		//return true if all elements are playable and uncovered
		for(Square s : anchor.getTile().getSquares()) {
			if(board.getBoardElt(row + s.getRelX(), col + s.getRelY()) instanceof UnplayableBoardElt == false) {
				if(((PlayableBoardElt) board.getBoardElt(row + s.getRelX(), col + s.getRelY())).getCovered()){
					valid = false;
				}
			} else {
				valid = false;
			}
		}
		return valid;
	}

}
