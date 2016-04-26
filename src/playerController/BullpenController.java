package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon, ndiwakar
 *
 */
public class BullpenController extends MouseAdapter {
	KabasujiPlayerApplication app;
	GameModel m;
	Bullpen bp;
	int boxwidth;
	
	public BullpenController(KabasujiPlayerApplication app, GameModel m, Bullpen bp, int boxwidth){
		super();
		this.app = app;
		this.m=m;
		this.bp = bp;
		this.boxwidth = boxwidth;
	}
	
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
	
	void processMousePressed(int x, int y, boolean isControlDown, boolean isShiftDown, boolean isLeftClick, boolean isRightClick){
			 
		int cellNum = x/boxwidth;
		
		Tile pressedTile = null;
		
		try{
			pressedTile = bp.getTiles().get(cellNum);
		}
		catch(IndexOutOfBoundsException e){
			return;
		}
	
		// If the control button is pressed, rotate a tile
		if(isControlDown){
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
		else if(isShiftDown){
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
		// If no tile is picked up, pick one up
		else if(app.getGameWindow().getDraggedTile() == null){
			// Pickup a tile
			PickUpTileBullpenMove move1 = new PickUpTileBullpenMove(app, m, pressedTile, bp);
			move1.execute();
			
			// Update the UI
			UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove(app, m);
			move.execute();
		}
		// If a tile is already pick up, return it to the bullpen
		else{
			// Return the tile to the bullpen
			Tile draggedTile = app.getGameWindow().getDraggedTile().getTile();
			TileToBullpenMove move = new TileToBullpenMove(app, m, draggedTile, m.getCurrentLevel().getBullpen());
			move.execute();
			
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent me){
		processMouseMoved();
	}
	
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
