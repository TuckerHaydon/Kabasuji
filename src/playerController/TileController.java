package playerController;

import java.awt.event.MouseEvent;

import playerBoundary.BoardView;
import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.GameModel;


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
		
		GameWindow gw = app.getGameWindow();
		TileView dragging_tv = gw.getDraggedTile();
		
		int mouse_x = me.getX();
		int mouse_y = me.getY();
		
		//change x, y of dragging tile
		dragging_tv.setLocation(mouse_x, mouse_y);
		
		//call to boundary?
		
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