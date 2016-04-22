package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LevelView;
import playerEntity.GameModel;

public class LevelController extends MouseAdapter {

	KabasujiPlayerApplication app;
	LevelView lv;
	
	public LevelController(KabasujiPlayerApplication app, LevelView lv){
		super();
		this.app = app;
		this.lv = lv;
	}	
	//@Override
	public void mouseDragged(MouseEvent me) {
		
		app.getGameWindow().getDraggedTile().setLocation(me.getX(), me.getY());
		app.getGameWindow().displayDraggedTile();
		
	}
	
	public void mouseReleased(MouseEvent me){
		app.getGameWindow().releaseDraggedTile();
		//TileToBoardMove tbm = new TileToBoardMove(app.getGameModel(), anchor, row, col);
		
		
		//TODO add identifying info to "location" of tile
	}
}

