package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class MirrorTileVerticalMove implements IMove{
	Tile tile;
	
	public MirrorTileVerticalMove(Tile tile){
		this.tile=tile;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		
		if(!this.isValid(app)){
			return false;
		}
		
		tile.flipVertical();
		app.getGameWindow().getLevelView().getScrollPane().repaint();		
		return true;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		tile.flipVertical();
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		return true;
	}

}
