package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Bullpen;
import playerEntity.Tile;

public class PickUpTileBullpenMove implements IMove{
	Tile tile;
	Bullpen bullpen;
	
	public PickUpTileBullpenMove(Tile tile, Bullpen bullpen){
		this.tile=tile;
		this.bullpen=bullpen;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		return bullpen.removeTile(tile);
	}

	
	public boolean isValid(KabasujiPlayerApplication app) {
		return true;
	}

}
