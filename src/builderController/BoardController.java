package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BoardView;
import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

public class BoardController extends MouseAdapter {
	
	BoardView bv;
	BuilderModel model;
	KabasujiBuilderApplication app;
	
	public BoardController(BoardView bv, BuilderModel model){
		this.model = model;
		this.bv = bv;
	}
	
	public void mouseClicked(MouseEvent me){
		int x = me.getX();
		int y = me.getY();
		System.out.println("Board Clicked.");
		
		// TODO find what object is at the location and create a move for it.
	}
	

}
