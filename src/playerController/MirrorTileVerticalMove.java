package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Tile;

public class MirrorTileVerticalMove implements IMove{
	Tile tile;
	
	public MirrorTileVerticalMove(Tile tile){
		this.tile=tile;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		tile.flipVertical();
		app.getGameWindow().updateView();
		
		return true;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return true;
	}

}
