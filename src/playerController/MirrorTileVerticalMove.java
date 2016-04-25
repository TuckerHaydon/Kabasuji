package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class MirrorTileVerticalMove extends Move{
	Tile tile;
	
	public MirrorTileVerticalMove(KabasujiPlayerApplication app, GameModel m, Tile tile){
		super(app, m);
		this.tile=tile;
	}
	
	@Override
	boolean doMove() {
		tile.flipVertical();
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
		tile.flipVertical();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

}
