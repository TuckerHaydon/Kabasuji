package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Bullpen;
import playerEntity.Tile;

public class PickUpTileBoardMove implements IMove{
	Tile tile;
	Bullpen bullpen;
	
	public PickUpTileBoardMove(Tile tile, Bullpen bullpen){
		this.tile=tile;
		this.bullpen=bullpen;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		bullpen.removeTile(tile);
		return true;
	}

	/*you can always pick it up from board*/
	public boolean isValid(KabasujiPlayerApplication app) {
		return true;
	}

}
