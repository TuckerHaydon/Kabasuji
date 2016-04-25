package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class RotateTileCounterClockwiseMove extends Move{
	Tile tile;
	
	public RotateTileCounterClockwiseMove(KabasujiPlayerApplication app, GameModel m, Tile tile){
		super(app, m);
		this.tile=tile;
	}
	
	@Override
	boolean doMove() {	
		tile.rotateLeft();
		app.getGameWindow().getLevelView().getScrollPane().repaint();		
		return true;
	}

	@Override
	boolean isValid() {
		return true;
	}
	
	@Override
	public boolean undo() {
		tile.rotateRight();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}
}
