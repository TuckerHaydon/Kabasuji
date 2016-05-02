package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * Mirror a tile vertically
 * @author tuckerhaydon
 *
 */
public class MirrorTileVerticalMove extends Move{
	Tile tile;
	
	/**
	 * Constructor for MirrorTileVerticalMove
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 * @param tile - tile being flipped
	 */
	public MirrorTileVerticalMove(KabasujiPlayerApplication app, GameModel m, Tile tile){
		super(app, m);
		this.tile=tile;
	}
	
	/**
	 * Execute the flip
	 */
	@Override
	boolean doMove() {
		tile.flipVertical();
		app.getGameWindow().getLevelView().getScrollPane().repaint();		
		return true;
	}

	/**
	 * Valid in every level
	 */
	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean undo() {
		if(UndoManager.peekMove() == null) return false;
		tile.flipVertical();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

}
