package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BoardView;
import builderBoundary.KabasujiBuilderApplication;
import builderEntity.Board;
import builderEntity.BuilderModel;

/**
 * BoardController class
 * This class is responsible for handling how the board interacts 
 * with mouse events. Only two mouse events are handled: press and drag
 * @see Board
 * @author tuckerhaydon
 */
public class BoardController extends MouseAdapter {
	
	KabasujiBuilderApplication app;
	BuilderModel model;
	BoardView bv;
	
	/**
	 * BoardController Constructor
	 * @param app
	 * @param model
	 * @param bv
	 */
	public BoardController(KabasujiBuilderApplication app, BuilderModel model, BoardView bv){
		super();
		
		if(app == null || model == null || bv == null){
			throw new RuntimeException();
		}
		
		this.app = app;
		this.model = model;
		this.bv = bv;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		
		// Determine the XY location where the mouse was clicked. 
		int x = me.getX();
		int y = me.getY();
		
		processMousePressed(x, y);
		
	}
	
	/**
	 * processes what happens on a mouse pressed on the board 
	 * @param x
	 * @param y
	 */
	void processMousePressed(int x, int y){

		// Determine the row/col where the mouse was clicked.
		int col = x/bv.getSquareWidth();
		int row = y/bv.getSquareWidth();

		Board b = bv.getBoard();
		
		ChangeBoardEltMove move = new ChangeBoardEltMove(app, model, b, row, col);
		move.execute();

		// Repaint the board
		app.repaintLevelEditor();
	}
	
	@Override
	public void mouseDragged(MouseEvent me){
		this.mousePressed(me);
	}

	

}
