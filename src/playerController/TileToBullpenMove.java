package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Bullpen;
import playerEntity.LightningLevel;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class TileToBullpenMove implements IMove{
	Tile tile;
	Bullpen bullpen;
	
	public TileToBullpenMove(Tile tile, Bullpen bullpen){
		this.tile=tile;
		this.bullpen=bullpen;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return bullpen.addTile(tile);
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		if(app.getGameModel().getCurrentLevel() instanceof LightningLevel) {
			return false;
		}
		return true;
	}
	
}
