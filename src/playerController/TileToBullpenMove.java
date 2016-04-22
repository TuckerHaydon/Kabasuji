package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Anchor;
import playerEntity.Bullpen;
import playerEntity.LightningLevel;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class TileToBullpenMove implements IMove{
	Tile tile;
	Bullpen bullpen;
	
	public TileToBullpenMove(Tile tile, Bullpen bullpen){
		this.tile=tile;
		this.bullpen=bullpen;
	}
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		
		if(!this.isValid(app)){
			return false;
		}
		
		// Add the tile to the bullpen
		boolean successful = bullpen.addTile(tile);
		
		// Release the dragged tile
		app.getGameWindow().releaseDraggedTile();
		
		// Repaint the bullpen
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		
		return successful;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		if(app.getGameModel().getCurrentLevel() instanceof LightningLevel) {
			return false;
		}
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		bullpen.removeTile(tile);
		app.getGameModel().getCurrentLevel().getBoard().addTile(tile,
				((Anchor)tile.getSquare(0,0)).getRowCol()[0],((Anchor)tile.getSquare(0,0)).getRowCol()[1]);
		return true;
	}
}
