package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class MirrorTileHorizontalMove implements IMove{
	Tile tile;
	
	public MirrorTileHorizontalMove(Tile tile){
		this.tile=tile;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		if(!this.isValid(app)){
			return false;
		}
				
		tile.flipHorizontal();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		tile.flipHorizontal();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

}
