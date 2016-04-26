package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.PuzzleLevelView;
import playerBoundary.TileView;
import playerEntity.Anchor;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.PuzzleLevel;
import playerEntity.Tile;

/**
 * 
 * @author 
 *
 */
public class PickUpTileBullpenMove extends Move{
	Tile tile;
	Bullpen bullpen;
	
	public PickUpTileBullpenMove(KabasujiPlayerApplication app, GameModel m, Tile tile, Bullpen bullpen){
		super(app, m);
		this.tile=tile;
		this.bullpen=bullpen;
	}
	
	@Override
	boolean doMove() {
		
		// Remove the tile from the bullpen
		bullpen.removeTile(tile);
		
		// Update the dragged tile view
		TileView tv = new TileView(app, m, tile);
		app.getGameWindow().setDraggedTile(tv);
		
		// Repaint the bullpen
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		
		return true;
	}

	@Override
	boolean isValid() {
		return true;
	}
	
	@Override
	public boolean undo() {
		return bullpen.addTile(tile.getReferenceNumber());
	}

}
