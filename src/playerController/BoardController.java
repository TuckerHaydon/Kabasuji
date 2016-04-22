package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.GameAchievementMonitor;
import playerEntity.GameModel;
import playerEntity.LevelAchievementMonitor;
import playerEntity.Tile;

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

	//activity here depends on what kind of level we have 
	@Override
	public void mousePressed(MouseEvent me){
				
		// Get the XY location of mouse event
		int x = me.getX();
		int y = me.getY();
		
		// Process the action
		processMousePressed(x, y);	
	}
	
	void processMousePressed(int x, int y){
		
		GameWindow gw = app.getGameWindow();
		GameModel m = app.getGameModel();
		
		// Determine the row/col of the mouse press
		int row = y / eltWidth;
		int col = x / eltWidth;	
		
		if(app.getGameWindow().getDraggedTile() == null){
			
			//BoardElt elt = b.getBoardElt(row, col);
			System.out.println(row + " " + col);
			Tile thisTile = b.getTile(row, col);
			
			//create new tileview
			TileView tv = new TileView(thisTile);
			app.getGameWindow().setDraggedTile(tv);

			//set dragged tile view, update coordinates, etc
			PickUpTileBoardMove pbm = new PickUpTileBoardMove (thisTile, b);
			pbm.doMove(app);
			
		}
		else{

			LevelAchievementMonitor AM = m.getCurrentAM();
			GameAchievementMonitor GAM = m.getGAM();
			TileView tileview = gw.getDraggedTile();
			if(tileview == null){
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

			// TODO consolidate this stuff in the completeLevelMove
			//achievement stuff goes here!
			CompleteLevelMove move = new CompleteLevelMove(m);
			if(move.isValid(app)){
				move.doMove(app);	
				app.displayLevelSelectionMenu();
				app.getGameWindow().updateView();
				if(GAM.updateAchievement(m.getCurrentLevel().getLevelNum())){
					GAM.pop();
				}
			}


			//This Anchor is just there for console reason
			Anchor a = new Anchor(row,col,tile);

			TileToBoardMove move2 = new TileToBoardMove(b,a,row,col);
			move2.doMove(app);

			//TODO move and app change stuff go there

//			if(AM.updateAchievement_releaseonboard()){
//				AM.popUpScreen();
//			}
//			else{
//				if(AM.updateAchievement_wheninvalidmove()){
//					AM.popUpScreen();
//				}
//			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent me){
		processMouseMoved();
	}
	
	void processMouseMoved(){
		
		// If there is not tile selected, do nothing
		if(app.getGameWindow().getDraggedTile() == null){
			return;
		}
		// If there is a tile selected, move it to the mouse location
		else{
			UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove();
			move.doMove(app);
		}
	}
}
