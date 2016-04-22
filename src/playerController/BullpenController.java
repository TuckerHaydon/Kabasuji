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
 * @author tuckerhaydon
 *
 */
public class BullpenController extends MouseAdapter {
	KabasujiPlayerApplication app;
	GameModel m;
	Bullpen bp;
	int boxwidth;
	
	public BullpenController(KabasujiPlayerApplication app, GameModel m, Bullpen bp, int boxwidth){
		super();
		this.bp = bp;
		this.app = app;
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
		
		Tile pressedTile = bp.getTiles().get(cellNum);
	
		// If the control button is pressed, rotate a tile
		if(isControlDown){
			if (isLeftClick){
				RotateTileClockwiseMove move = new RotateTileClockwiseMove(pressedTile);
				move.doMove(app);
			}
			else if (isRightClick)
			{
				RotateTileCounterClockwiseMove move = new RotateTileCounterClockwiseMove(pressedTile);
				move.doMove(app);
			}
		}
		// If the shift button is pressed, mirror a tile
		else if(isShiftDown){
			if (isLeftClick){
				MirrorTileHorizontalMove move = new MirrorTileHorizontalMove(pressedTile);
				move.doMove(app);
			}
			else if (isRightClick)
			{
				MirrorTileVerticalMove move = new MirrorTileVerticalMove(pressedTile);
				move.doMove(app);
			}
		}
		// TODO check whether or not a tile is picked up and move it
		else{
			
			TileView tv = new TileView(pressedTile);
			app.getGameWindow().setDraggedTile(tv);
			bp.removeTile(pressedTile);
			
			double mouseLocationX = app.getGameWindow().getMousePosition().getX();
			double mouseLocationY = app.getGameWindow().getMousePosition().getY();
			
			int centerLocationX = (int)(mouseLocationX - 3.5*app.getGameWindow().getDraggedTile().getSquareWidth());
			int centerLocationY = (int)(mouseLocationY - 4*app.getGameWindow().getDraggedTile().getSquareWidth());
			
			tv.setLocation(centerLocationX, centerLocationY);
			app.getGameWindow().displayDraggedTile();
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
			UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove();
			move.doMove(app);
		}
	}	
}
