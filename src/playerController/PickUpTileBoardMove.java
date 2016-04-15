package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Board;
import playerEntity.Bullpen;
import playerEntity.Tile;

public class PickUpTileBoardMove implements IMove{
	Tile tile;
	Board board;
	
	public PickUpTileBoardMove(Tile tile, Board board){
		this.tile=tile;
		this.board=board;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		board.removeTile(tile);
		return true;
	}

	/*you can always pick it up from board*/
	public boolean isValid(KabasujiPlayerApplication app) {
		return true;
	}

}
