package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Anchor;
import playerEntity.Board;

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
		return false;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return false;
	}

}
