package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.GameAchievementMonitor;
import playerEntity.GameModel;
import playerEntity.LevelAchievementMonitor;
import playerEntity.NumberBoardElt;
import playerEntity.PlayableBoardElt;
import playerEntity.ReleaseLevel;
import playerEntity.Tile;
import playerEntity.UnplayableBoardElt;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class BoardController extends MouseAdapter{
	Board b;
	KabasujiPlayerApplication app;
	int eltWidth;
	
	public BoardController(Board b, KabasujiPlayerApplication app, int eltWidth){
		super();
		this.app=app;
		this.b=b;
		this.eltWidth = eltWidth;
	}
	
	public void mouseDragged(MouseEvent me){
		
		//update x,y position of tile
		app.getGameWindow().getDraggedTile().setLocation(me.getX(), me.getY());
		app.getGameWindow().displayDraggedTile();
	}
	
	//activity here depends on what kind of level we have 
	public void mousePressed(MouseEvent me){
	
		// Get the XY location of mouse event
		int x = me.getX();
		int y = me.getY();
		
		// Determine which BoardElt that is
		int row = y / eltWidth;
		int col = x / eltWidth;
		BoardElt elt = b.getBoardElt(row, col);
		
		//check if elt is covered
		//if tile exists and it is release level
		//create new tileview
		//set dragged tile view, update coordinates, etc
		
		if(elt instanceof PlayableBoardElt && elt instanceof NumberBoardElt){
			NumberBoardElt nbElt = (NumberBoardElt) elt;
			if(nbElt.getCovered() && (app.getGameModel().getCurrentLevel() instanceof ReleaseLevel)){
				System.out.println("PlayableBoardElt and NumberedBoardElt");
				//getTile(row, col);
				//TileView tv = new TileView(Tile);
			}
			else if (nbElt.getCovered() && !(app.getGameModel().getCurrentLevel() instanceof ReleaseLevel)){
				return;
			}
			
		}
	
		
		//else if(elt instanceof UnplayableBoardElt){
		//	System.out.println("UnplayableBoardElt");
		//	}
		
			
		System.out.println(row + " "+col);
		
	}
	
	
	public void mouseReleased(MouseEvent me){
		
		GameWindow gw = app.getGameWindow();
		GameModel m = app.getGameModel();
		
		int x = me.getX();
		int y = me.getY();

		// Find the element at that location
		// Determine if a tile is there
		// TODO
		
		// Determine which BoardElt that is
		int row = y / eltWidth;
		int col = x / eltWidth;
		
		//Check if covered
		//if covered, send tile back to anchor location
		
		LevelAchievementMonitor AM = m.getCurrentAM();
		GameAchievementMonitor GAM = m.getGAM();
		TileView tileview = gw.getDraggedTile();
		if(tileview==null){
			System.err.println("Null TileView::BoardController::mouseReleased");
			gw.releaseDraggedTile();
			return;
		}

		Tile tile = tileview.getTile();
		if(tile==null){
			System.err.println("Null Tile::BoardController::mouseReleased");
			gw.releaseDraggedTile();
			return;
		}
		gw.releaseDraggedTile();
		
		//achievement stuff goes here!
		
		IMove move = new CompleteLevelMove(m);
		if(move.doMove(app)){
			app.displayLevelSelectionMenu();
			app.getGameWindow().updateView();
			if(GAM.updateAchievement(m.getCurrentLevel().getLevelNum())){
				GAM.pop();
			}
		}
		
		
		//This Anchor is just there for console reason
		Anchor a = new Anchor(row,col,tile);
		
		IMove move2 = new TileToBoardMove(b,a,row,col);
		if(move2.doMove(app)){
			
			//TODO move and app change stuff go there
			
//			if(AM.updateAchievement_releaseonboard()){
//				AM.popUpScreen();
//			}
		}
		else{
			if(AM.updateAchievement_wheninvalidmove()){
				AM.popUpScreen();
			}
		}
	}
	
}
