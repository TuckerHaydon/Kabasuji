package playerController;

import java.awt.event.MouseEvent;

import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon, ndiwakar
 *
 */
public class UnplayableBoardEltController extends java.awt.event.MouseAdapter {

	KabasujiPlayerApplication app;
	GameModel m;
	GameWindow gw;
	
	public UnplayableBoardEltController(KabasujiPlayerApplication app, GameWindow gw, GameModel m){
		super();
		this.app = app;
		this.gw = gw;
		this.m = m;
	}
	
	public void mouseDragged(MouseEvent me){
		
		GameWindow gw = app.getGameWindow();
		TileView dragging_tv = gw.getDraggedTile();
		
		int mouse_x = me.getX();
		int mouse_y = me.getY();
		
		dragging_tv.setLocation(mouse_x, mouse_y);

	}
	
	public void mouseReleased(MouseEvent me){
		
		GameWindow gw = app.getGameWindow();
		
		//gw.setDraggedTile(null);
		gw.releaseDraggedTile();
		
		
	}
	
}

