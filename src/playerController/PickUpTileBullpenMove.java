package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Anchor;
import playerEntity.Bullpen;
import playerEntity.Tile;

/**
 * 
 * @author 
 *
 */
public class PickUpTileBullpenMove implements IMove{
	Tile tile;
	Bullpen bullpen;
	
	public PickUpTileBullpenMove(Tile tile, Bullpen bullpen){
		this.tile=tile;
		this.bullpen=bullpen;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		
		if(!this.isValid(app)){
			return false;
		}
		
		// Remove the tile from the bullpen
		bullpen.removeTile(tile);
		
		// Update the dragged tile view
		TileView tv = new TileView(tile);
		app.getGameWindow().setDraggedTile(tv);
		
		// Repaint the bullpen
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		
		return true;
	}

	
	public boolean isValid(KabasujiPlayerApplication app) {
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		return bullpen.addTile(tile.getReferenceNumber());
	}

}
