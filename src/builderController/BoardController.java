package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BoardView;
import builderBoundary.KabasujiBuilderApplication;

public class BoardController extends MouseAdapter {
	
	BoardView bv;
	KabasujiBuilderApplication app;
	
	public BoardController(BoardView bv, KabasujiBuilderApplication app){
		this.app = app;
		this.bv = bv;
	}
	
	public void mouseClicked(MouseEvent me){
		int x = me.getX();
		int y = me.getY();
		System.out.println("Ive been clicked!");
		
		// TODO find what object is at the location and create a move for it.
	}
	

}
