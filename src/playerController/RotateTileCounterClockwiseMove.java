package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * Rotate the tile counterclockwise
 * @author tuckerhaydon
 *
 */
public class RotateTileCounterClockwiseMove extends Move{
	Tile tile;
	
	/**
	 * Constructor for a rotate tile counterclockwise move
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 * @param tile - tile being rotated
	 */
	public RotateTileCounterClockwiseMove(KabasujiPlayerApplication app, GameModel m, Tile tile){
		super(app, m);
		this.tile=tile;
	}
	
	/**
	 * Rotate the tile view in counter clockwise direction
	 */
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
		if(UndoManager.peekMove() == null) return false;
		tile.rotateRight();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}
}
