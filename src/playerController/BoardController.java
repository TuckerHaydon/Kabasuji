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
import playerEntity.Tile;
import playerEntity.Square;

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
	
		GameWindow gw = app.getGameWindow();
		GameModel m = app.getGameModel();
		
		// Get the XY location of the mouse event
		int x = me.getX();
		int y = me.getY();
		
		// If nothing is picked up, will either try and return a tile to the bullpen or translate the tile
		if(app.getGameWindow().getDraggedTile() == null){
			
			System.out.println("Want to translate a tile.");
		
	
			// Determine which BoardElt that is
			int row = y / eltWidth;
			int col = x / eltWidth;
			BoardElt elt = b.getBoardElt(row, col);
	
			Tile thisTile = b.getTile(row, col);
	
			//create new tileview
			TileView tv = new TileView(thisTile);
			app.getGameWindow().setDraggedTile(tv);
	
			//set dragged tile view, update coordinates, etc
			PickUpTileBoardMove pbm = new PickUpTileBoardMove (thisTile, b);
			if(pbm.isValid(app)){
				pbm.doMove(app);
			}
		}
		// Going to place a tile on the board
		else{
			
			System.out.println("Want to place a tile.");

			// Determine which BoardElt that is
			int row = y / eltWidth;
			int col = x / eltWidth;		

			LevelAchievementMonitor AM = m.getCurrentAM();
			GameAchievementMonitor GAM = m.getGAM();
			TileView tileview = gw.getDraggedTile();
			
			if(tileview==null){
				System.err.println("Null TileView::BoardController::mouseReleased");
				gw.releaseDraggedTile();
				return;
			}

			Tile tile = tileview.getTile();
			gw.releaseDraggedTile();

			//achievement stuff goes here!

			IMove move = new CompleteLevelMove(m);
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

			IMove move2 = new TileToBoardMove(b,a,row,col);
			if(move2.isValid(app)){
				move2.doMove(app);
			}

			//TODO move and app change stuff go there

			//			if(AM.updateAchievement_releaseonboard()){
			//				AM.popUpScreen();
			//			}
			else{
				if(AM.updateAchievement_wheninvalidmove()){
					AM.popUpScreen();
				}
			}
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent me){
		
		if(app.getGameWindow().getDraggedTile() == null){
			return;
		}
		else{
			double mouseLocationX = app.getGameWindow().getMousePosition().getX();
			double mouseLocationY = app.getGameWindow().getMousePosition().getY();
			
			int centerLocationX = (int)(mouseLocationX - 3.5*app.getGameWindow().getDraggedTile().getSquareWidth());
			int centerLocationY = (int)(mouseLocationY - 4*app.getGameWindow().getDraggedTile().getSquareWidth());
					
			app.getGameWindow().getDraggedTile().setLocation(centerLocationX, centerLocationY);
			app.getGameWindow().displayDraggedTile();
		}
		
		
	}

}
