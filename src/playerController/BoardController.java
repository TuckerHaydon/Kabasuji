package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.GameModel;
import playerEntity.NumberBoardElt;
import playerEntity.PlayableBoardElt;
import playerEntity.Tile;
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
	
	//TODO add mousedragged
	
	//activity here depends on what kind of level we have 
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
		System.out.println(row + " "+col);
		if(elt instanceof NumberBoardElt){System.out.println("NumberBoardElt");}
		else if(elt instanceof PlayableBoardElt){System.out.println("PlayableBoardElt");}
		else if(elt instanceof UnplayableBoardElt){System.out.println("UnplayableBoardElt");}
	}
	
	
	public void mouseReleased(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();

		// Find the element at that location
		// Determine if a tile is there
		// TODO
		
		// Determine which BoardElt that is
		int row = y / eltWidth;
		int col = x / eltWidth;
		
		GameWindow gw = app.getGameWindow();
		GameModel m = app.getGameModel();
		TileView tileview = gw.getDraggedTile();
		if(tileview==null){
			System.err.println("Null TileView::BoardController::mouseReleased");
			return;
		}
		Tile tile = tileview.getTile();
		if(tile==null){
			System.err.println("Null Tile::BoardController::mouseReleased");
			return;
		}
		gw.setDraggedTile(null);
		
		//achievement stuff goes here!
		
		IMove move = new CompleteLevelMove(m);
		if(move.doMove(app)){
			app.displayLevelSelectionMenu();
			app.getGameWindow().updateView();
			if(m.getGAM().updateAchievement(m.getCurrentLevel().getLevelNum())){
				m.getGAM().pop();
			}
		}
		
		
		
		Anchor a = new Anchor(row,col,tile);
		
		IMove move = new TileToBoardMove(b,);
		else{
			if(m.getCurrentAM().updateAchievement_releaseonboard()){
				m.getCurrentAM().popUpScreen();
			}
		}
	}
	
}
