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
 * 
 * @author tuckerhaydon
 *
 */
public class LevelController extends MouseAdapter {

	KabasujiPlayerApplication app;
	LevelView lv;
	GameModel m;
	
	public LevelController(KabasujiPlayerApplication app, GameModel m, LevelView lv){
		super();
		this.app = app;
		this.lv = lv;
		this.m = m;
	}	
	
	@Override
	public void mousePressed(MouseEvent me){
		processMousePressed();
	}
	
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

