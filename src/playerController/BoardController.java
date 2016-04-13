package playerController;

<<<<<<< HEAD
import java.awt.event.MouseEvent;
import playerBoundary.BoardView;
import playerBoundary.KabasujiPlayerApplication;

public class BoardController extends java.awt.event.MouseAdapter {
	
	KabasujiPlayerApplication app;
	BoardView bv;
	
	public BoardController(KabasujiPlayerApplication app, BoardView bv){
		super();
		
		this.app = app;
		this.bv = bv;
	}
=======
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
>>>>>>> branch 'master' of https://github.com/TuckerHaydon/Kabasuji-Cebriones

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.GameModel;
import playerEntity.NumberBoardElt;
import playerEntity.PlayableBoardElt;
import playerEntity.UnplayableBoardElt;

public class BoardController extends MouseAdapter{
	Board b;
	KabasujiPlayerApplication app;
	int eltWidth;
	
	public BoardController(Board b, KabasujiPlayerApplication app, int eltWidth){
		this.app=app;
		this.b=b;
		this.eltWidth = eltWidth;
	}
	
	public void mousePressed(MouseEvent me){
	
		// Get the XY location of mouse event
		int x = me.getX();
		int y = me.getY();
		
		// Find the element at that location
		// Determine if a tile is there
		// TODO
		
		// Determine which BoardElt that is
		int row = y / eltWidth;
		int col = x / eltWidth;
		BoardElt elt = b.getBoardElt(row, col);
		if(elt instanceof NumberBoardElt){System.out.println("NumberBoardElt");}
		else if(elt instanceof PlayableBoardElt){System.out.println("PlayableBoardElt");}
		else if(elt instanceof UnplayableBoardElt){System.out.println("UnplayableBoardElt");}
	}
	
	
	public void mouseRelease(MouseEvent me){
		
		
		
		
		
		//achievement stuff goes here!
		
		
	}
	
}
