package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class MirrorTileHorizontalMove extends Move{
	Tile tile;
	
	public MirrorTileHorizontalMove(KabasujiPlayerApplication app, GameModel m, Tile tile){
		super(app, m);
		this.tile=tile;
	}
	
	@Override
	public boolean doMove() {
		tile.flipHorizontal();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean undo() {
		tile.flipHorizontal();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

}
