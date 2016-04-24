package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class RotateTileCounterClockwiseMove implements IMove{
	Tile tile;
	
	public RotateTileCounterClockwiseMove(Tile tile){
		this.tile=tile;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		
		if(!this.isValid(app)){
			return false;
		}
		
		tile.rotateLeft();
		app.getGameWindow().getLevelView().getScrollPane().repaint();		
		return true;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		tile.rotateRight();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}
}
