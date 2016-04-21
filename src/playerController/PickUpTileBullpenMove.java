package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Anchor;
import playerEntity.Bullpen;
import playerEntity.Tile;

/**
 * 
 * @author 
 *
 */
public class PickUpTileBullpenMove implements IMove{
	Tile tile;
	Bullpen bullpen;
	
	public PickUpTileBullpenMove(Tile tile, Bullpen bullpen){
		this.tile=tile;
		this.bullpen=bullpen;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		if(isValid(app)){
			return bullpen.removeTile(tile);
		}
		return false;
	}

	
	public boolean isValid(KabasujiPlayerApplication app) {
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		return bullpen.addTile(tile.getReferenceNumber());
	}

}
