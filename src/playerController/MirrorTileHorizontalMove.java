package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * Mirrors a tile horizontally
 * @author tuckerhaydon
 *
 */
public class MirrorTileHorizontalMove extends Move{
	Tile tile;
	
	/**
	 * Constructor for MirrorTileHorizontalMove
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 * @param tile - tile being mirrored
	 */
	public MirrorTileHorizontalMove(KabasujiPlayerApplication app, GameModel m, Tile tile){
		super(app, m);
		this.tile=tile;
	}
	
	/**
	 * Execute the flip horizontal move
	 */
	@Override
	public boolean doMove() {
		tile.flipHorizontal();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}
	
	/**
	 * Checks valditity. It is always valid.
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean undo() {
		if(UndoManager.peekMove() == null) return false;
		tile.flipHorizontal();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

}
