package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerEntity.Anchor;
import playerEntity.GameModel;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LevelView;
import playerBoundary.TileView;
import playerEntity.Square;
import playerEntity.Tile;

/**
 * Controller for a level 
 * @author tuckerhaydon, ndiwakar
 *
 */
public class LevelController extends MouseAdapter {

	KabasujiPlayerApplication app;
	LevelView lv;
	GameModel m;
	
	/**
	 * Constructor for a level controller
	 * @param app - top level Kabasuji application
	 * @param m - top level game model
	 * @param lv - level view for the level being controlled
	 */
	public LevelController(KabasujiPlayerApplication app, GameModel m, LevelView lv){
		super();
		this.app = app;
		this.lv = lv;
		this.m = m;
	}	
	
	/**
	 * Handles mouseEvents
	 */
	@Override
	public void mousePressed(MouseEvent me){
		processMousePressed();
	}
	
	/**
	 * When the mouse is pressed on the level (anywhere outside of the bullpen and board),
	 * the tile is sent back to the bullpen
	 */
	void processMousePressed(){
		
		TileView draggedTileView = app.getGameWindow().getDraggedTile();
		
		// If no tile is selected, do nothing
		if(draggedTileView == null){
			return;
		}
		// If a tile is selected, move it to the bullpen
		else{
			Tile draggedTile = draggedTileView.getTile();
			TileToBullpenMove move = new TileToBullpenMove(app, m, draggedTile, m.getCurrentLevel().getBullpen());
			move.execute();
			lv.repaint();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent me){
		processMouseMoved();
	}
	
	/**
	 * Updates the view of the dragged tile
	 */
	void processMouseMoved(){
		
		// If there is no tile selected, do nothing
		if(app.getGameWindow().getDraggedTile() == null){
			return;
		}
		// If a tile is selected, move it to the mouse location
		else{
			UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove(app, m);
			move.execute();
		}
	}
}

