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
 * Controls all of the mouse events that occur over the player application board
 * @author tuckerhaydon, ndiwakar
 */

public class BoardController extends MouseAdapter{
	KabasujiPlayerApplication app;
	GameModel m;
	Board b;
	int eltWidth;

	/**
	 * Constructor for a board controller
	 * @param app - The top-level Kabasuji player application
	 * @param m - The top-level game model
	 * @param b - The board being controlled
	 * @param eltWidth - The width of a board element (division and spacing of board)
	 */
	public BoardController(KabasujiPlayerApplication app, GameModel m, Board b, int eltWidth){
		super();
		this.app=app;
		this.m=m;
		this.b=b;
		this.eltWidth = eltWidth;
	}

	/**
	 * Takes care of mousePresses
	 */
	@Override
	public void mousePressed(MouseEvent me){
				
		// Get the XY location of mouse event
		int x = me.getX();
		int y = me.getY();
		
		// Process the action
		processMousePressed(x, y);	
	}
	
	/**
	 * Responds to mousePressed: either puts down the current draggedTile or picks up a tile from the board if legal
	 * @param x - x coordinate of mousePress
	 * @param y - y coordinate of mousePress
	 */
	void processMousePressed(int x, int y){
		
		GameWindow gw = app.getGameWindow();
		
		// Determine the row/col of the mouse press
		int row = y / eltWidth;
		int col = x / eltWidth;	
		
		// If no tile is currently picked up
		if(app.getGameWindow().getDraggedTile() == null){

			
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

			TileToBoardMove move2 = new TileToBoardMove(app, m, b,selectedTile,row,col);
			move2.execute();
			
		}
		
	}
	
	/**
	 * Handles the mouseMove events
	 */
	@Override
	public void mouseMoved(MouseEvent me){
		processMouseMoved();
	}
	
	/**
	 * Redraws the draggedTile using the coordinates of the mouseMove (x,y)
	 */
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
