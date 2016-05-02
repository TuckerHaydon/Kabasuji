package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * Controls all of the mouse events that occur over the player application bullpen
 * @author tuckerhaydon, ndiwakar
 *
 */
public class BullpenController extends MouseAdapter {
	KabasujiPlayerApplication app;
	GameModel m;
	Bullpen bp;
	int boxwidth;
	
	/**
	 * Constructor for bullpen controller
	 * @param app - The top-level Kabasuji player application
	 * @param m- The top-level game model
	 * @param bp - The bullpen being controlled
	 * @param boxwidth - The width of each tile box in the bullpen (spacing and division)
	 */
	public BullpenController(KabasujiPlayerApplication app, GameModel m, Bullpen bp, int boxwidth){
		super();
		this.app = app;
		this.m=m;
		this.bp = bp;
		this.boxwidth = boxwidth;
	}
	
	/**
	 * Handles mousePresses
	 * Registers the x,y position of the press
	 * as well as the ctrl and shift keys during mousePress (rotation/mirror)
	 */
	@Override
	public void mousePressed(MouseEvent me){
		
		// Get the XY location of the mouse event
		int x = me.getX();
		int y = me.getY();
		
		// Get the relevant mouse data
		boolean isControlDown = me.isControlDown();
		boolean isShiftDown = me.isShiftDown();
		boolean isLeftClick = me.getButton() == MouseEvent.BUTTON1;
		boolean isRightClick = me.getButton() == MouseEvent.BUTTON3;
		
		// Process the move
		processMousePressed(x, y, isControlDown, isShiftDown, isLeftClick, isRightClick);
		
	}
	
	/**
	 * Processes the mousePress event based on the input (mouse/ctrl/shift).
	 * Finds the place where the mousePress has occurred and then 
	 * rotates or flips the tile based on location
	 * 
	 * @param x - x coordinate of mousePress
	 * @param y - y coordinate of mousePress
	 * @param isControlDown - true if ctrl has been pressed
	 * @param isShiftDown - true if shift has been pressed
	 * @param isLeftClick - true if left click has been used
	 * @param isRightClick - true if right click has been used
	 */
	void processMousePressed(int x, int y, boolean isControlDown, boolean isShiftDown, boolean isLeftClick, boolean isRightClick){
			 
		int cellNum = x/boxwidth;
		
		Tile pressedTile = null;
		
		try{
			pressedTile = bp.getTiles().get(cellNum);
		}
		catch(IndexOutOfBoundsException e){
			if(app.getGameWindow().getDraggedTile() != null){
				Tile draggedTile = app.getGameWindow().getDraggedTile().getTile();
				TileToBullpenMove move = new TileToBullpenMove(app, m, draggedTile, m.getCurrentLevel().getBullpen());
				move.execute();
				app.getGameWindow().getLevelView().updateUI();
			}
			return;
		}
	
		if(!isControlDown && !isShiftDown){

			// If no tile is picked up, pick one up
			if(app.getGameWindow().getDraggedTile() == null){
				// Pickup a tile
				PickUpTileBullpenMove move1 = new PickUpTileBullpenMove(app, m, pressedTile, bp);
				move1.execute();
				
				// Update the UI
				UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove(app, m);
				move.execute();
			}
			else{
				// If a tile is already pick up, return it to the bullpen
				Tile draggedTile = app.getGameWindow().getDraggedTile().getTile();
				TileToBullpenMove move = new TileToBullpenMove(app, m, draggedTile, m.getCurrentLevel().getBullpen());
				move.execute();
				app.getGameWindow().getLevelView().updateUI();
			}
		}
		// If the control button is pressed, rotate a tile
		else if(isControlDown && app.getGameWindow().getDraggedTile()==null){
			if (isLeftClick){
				RotateTileClockwiseMove move = new RotateTileClockwiseMove(app, m, pressedTile);
				move.execute();
			}
			else if (isRightClick)
			{
				RotateTileCounterClockwiseMove move = new RotateTileCounterClockwiseMove(app, m, pressedTile);
				move.execute();
			}
		}
		// If the shift button is pressed, mirror a tile
		else if(isShiftDown && app.getGameWindow().getDraggedTile()==null){
			if (isLeftClick){
				MirrorTileHorizontalMove move = new MirrorTileHorizontalMove(app, m, pressedTile);
				move.execute();
			}
			else if (isRightClick)
			{
				MirrorTileVerticalMove move = new MirrorTileVerticalMove(app, m, pressedTile);
				move.execute();
			}
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
		if(app.getGameWindow().getDraggedTile() == null){
			return;
		}
		else{
			UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove(app, m);
			move.execute();
		}
	}	
}
