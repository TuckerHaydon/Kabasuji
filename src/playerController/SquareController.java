package playerController;

import java.awt.event.MouseEvent;

import playerBoundary.BoardView;
import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.GameModel;


public class SquareController extends java.awt.event.MouseAdapter{
	
	KabasujiPlayerApplication app;
	BoardView bv;
	GameModel m;	
	
	public SquareController (KabasujiPlayerApplication app, BoardView boardview, GameModel model){
		super();
		
		this.app = app;
		this.bv = boardview;
		this.m = model;
	}
	
	public void mouseDragged(MouseEvent me){
		
	}
	
	public void mousePressed(MouseEvent me){
		
		GameWindow gw = app.getGameWindow();
		
	}
	
	public void mouseReleased(MouseEvent me){
		
		GameWindow gw = app.getGameWindow();
		
		TileView draggingTile = gw.getDraggedTile();
		//if (draggingTile == gw.getNothingBeingDragged()) {
		//	System.err.println ("SquareController::mouseReleased() unexpectedly found nothing being dragged.");
		//	gw.releaseDraggingTile();
		
		
	}

}