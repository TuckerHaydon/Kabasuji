package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Tile;

public class RotateTileCounterClockwiseMove implements IMove{
	Tile tile;
	
	public RotateTileCounterClockwiseMove(Tile tile){
		this.tile=tile;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		
		tile.rotateLeft();
		app.getGameWindow().updateView();
		
		return true;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return true;
	}

}
