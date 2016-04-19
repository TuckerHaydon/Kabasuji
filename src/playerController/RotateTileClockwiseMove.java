package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class RotateTileClockwiseMove implements IMove{
	Tile tile;
	
	public RotateTileClockwiseMove(Tile tile){
		this.tile=tile;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		
		tile.rotateRight();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return true;
	}

}
