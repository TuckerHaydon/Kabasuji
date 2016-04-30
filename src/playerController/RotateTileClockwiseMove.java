package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class RotateTileClockwiseMove extends Move{
	Tile tile;
	
	public RotateTileClockwiseMove(KabasujiPlayerApplication app, GameModel m, Tile tile){
		super(app, m);
		this.tile=tile;
	}
	
	@Override
	boolean doMove() {
		tile.rotateRight();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean undo() {
		if(UndoManager.peekMove() == null) return false;
		tile.rotateLeft();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}
}
