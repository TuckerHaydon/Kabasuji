package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BoardView;
import builderEntity.Board;
import builderEntity.BuilderModel;

public class BoardController extends MouseAdapter {
	
	BoardView bv;
	BuilderModel model;
	
	public BoardController(BoardView bv, BuilderModel model){
		this.model = model;
		this.bv = bv;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		
		// Determine the XY location where the mouse was clicked. 
		int x = me.getX();
		int y = me.getY();

		// Determine the row/col where the mouse was clicked.
		int col = x/bv.getSquareWidth();
		int row = y/bv.getSquareWidth();

		Board b = bv.getBoard();
		
		ChangeBoardEltMove move = new ChangeBoardEltMove(model, b, row, col);
		
		if(move.isValid()){
			move.doMove();
		}

		// Repaint the board
		bv.repaint();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent me){
		this.mousePressed(me);
	}
	

}
