package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Board;
import playerEntity.GameAchievementMonitor;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * Controls all of the mouse events that occur over the Board
 * @author tuckerhaydon, ndiwakar
 */

public class BoardController extends MouseAdapter{
	KabasujiPlayerApplication app;
	GameModel m;
	Board b;
	int eltWidth;

	public BoardController(KabasujiPlayerApplication app, GameModel m, Board b, int eltWidth){
		super();
		this.app=app;
		this.m=m;
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
		
		// Determine the row/col of the mouse press
		int row = y / eltWidth;
		int col = x / eltWidth;	
		
		// If no tile is currently picked up
		if(app.getGameWindow().getDraggedTile() == null){
			
			//BoardElt elt = b.getBoardElt(row, col);
//			System.out.println(row + " " + col);
			
			// Determine if there is a tile at the location of the mouse click
			Tile selectedTile = b.getTile(row, col);
			
			// If there is no tile at the location of the mouse press, do nothing
			if(selectedTile == null){
				System.err.println("No tile here.");
			}
			// If there is a tile at this location, pick it up
			else
			{
				PickUpTileBoardMove pbm = new PickUpTileBoardMove (app, m, selectedTile, b);
				pbm.execute();
			}
			
		}
		// If a tile is picked up, try and place it on the board
		else{

			
			
			
			// Get the TileView and Tile
			TileView tileview = gw.getDraggedTile();
			Tile selectedTile = tileview.getTile();
			
			// Validate the tile in the TileView
			if(selectedTile==null){
				System.err.println("Null Tile::BoardController::mouseReleased");
				gw.releaseDraggedTile();
				return;
			}

			
			//TODO GAM need to know if the CompleteLevelMove is valid
			//but IDK if we should put it into the move class
			GameAchievementMonitor GAM = m.getGAM();
			if(GAM.updateAchievement(m.getCurrentLevel().getLevelNum())){
				GAM.pop();
			}


			TileToBoardMove move2 = new TileToBoardMove(app, m, b,selectedTile,row,col);
			move2.execute();
			
			
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
			UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove(app, m);
			move.execute();
		}
	}
}
