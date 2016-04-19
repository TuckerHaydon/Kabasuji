package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Board;
import playerEntity.Bullpen;
import playerEntity.LightningLevel;
import playerEntity.Tile;

/**
 * 
 * @author 
 *
 */
public class PickUpTileBoardMove implements IMove{
	Tile tile;
	Board board;
	
	public PickUpTileBoardMove(Tile tile, Board board){
		this.tile=tile;
		this.board=board;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		if(isValid(app)) return board.removeTile(tile);
		return false;
	}

	/*you can always pick it up from board*/
	public boolean isValid(KabasujiPlayerApplication app) {
		if(app.getGameModel().getCurrentLevel() instanceof LightningLevel) {
			return false;
		}
		return true;
	}

}
