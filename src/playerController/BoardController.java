package playerController;

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

}
