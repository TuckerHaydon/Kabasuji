package playerController;

import java.awt.event.MouseEvent;
import playerBoundary.BoardView;
import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class TileController extends java.awt.event.MouseAdapter{
	
	KabasujiPlayerApplication app;
	BoardView bv;
	GameModel m;	
	
	public TileController (KabasujiPlayerApplication app, BoardView boardview, GameModel model){
		super();
		
		this.app = app;
		this.bv = boardview;
		this.m = model;
	}
	
	public void mouseDragged(MouseEvent me){
		
		//update x,y location of tile
		app.getGameWindow().getDraggedTile().setLocation(me.getX(), me.getY());
		app.getGameWindow().displayDraggedTile();
		
		//call to boundary
		
	}
	
	public void mousePressed(MouseEvent me){
		
		GameWindow gw = app.getGameWindow();
		
		int mouse_x = me.getX();
		int mouse_y = me.getY();
		
		//do some math to figure which tile/tileview it is
		//gw.setDraggedTile(tView);
		
	}
	
	public void mouseReleased(MouseEvent me){
		
		//release dragging tile
	
		GameWindow gw = app.getGameWindow();
		
		gw.setDraggedTile(null);
		
		//if (draggingTile == gw.getNothingBeingDragged()) {
		//	System.err.println ("SquareController::mouseReleased() unexpectedly found nothing being dragged.")
		
		
	}

}