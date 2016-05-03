package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * Rotate a tile clockwise
 * @author tuckerhaydon
 *
 */
public class RotateTileClockwiseMove extends Move{
	Tile tile;
	
	/**
	 * Constructor for a rotate tile clockwise move
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 * @param tile - tile being rotated
	 */
	public RotateTileClockwiseMove(KabasujiPlayerApplication app, GameModel m, Tile tile){
		super(app, m);
		this.tile=tile;
	}
	
	/**
	 * Rotate the tile in clockwise direction
	 */
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
