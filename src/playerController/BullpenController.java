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
		
		// If no tile is picked up, either going to mirror, flip, or pick up a tile
		if(app.getGameWindow().getDraggedTile() == null){
			
			System.out.println("Want to rotate, mirror, or release a tile");
			
			// Get the XY location of the mouse event
			int x = me.getX();
			int y = me.getY();
			
			// Convert that into a cellnum
			int cellNum = x/boxwidth;
			
			// Get the tile that has been pressed
			Tile pressedTile = bp.getTiles().get(cellNum);
		
			// If the control button is pressed, rotate a tile
			if(me.isControlDown()){
				if (me.getButton() == MouseEvent.BUTTON1){
					RotateTileClockwiseMove move = new RotateTileClockwiseMove(pressedTile);
					if(move.isValid(app)){
						move.doMove(app);
					}
				}
				else if (me.getButton() == MouseEvent.BUTTON3)
				{
					RotateTileCounterClockwiseMove move = new RotateTileCounterClockwiseMove(pressedTile);
					if(move.isValid(app)){
						move.doMove(app);
					}
				}
			}
			// If the shift button is pressed, mirror a tile
			else if(me.isShiftDown()){
				if (me.getButton() == MouseEvent.BUTTON1){
					MirrorTileHorizontalMove move = new MirrorTileHorizontalMove(pressedTile);
					if(move.isValid(app)){
						move.doMove(app);
					}
				}
				else if (me.getButton() == MouseEvent.BUTTON3)
				{
					MirrorTileVerticalMove move = new MirrorTileVerticalMove(pressedTile);
					if(move.isValid(app)){
						move.doMove(app);
					}
				}
			}
			// If neither shift nor control are help down, pick up the tile
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
		// If a tile is picked up already, put it back in the bullpen
		else{
			
			System.out.println("Want to release a tile.");
			
			Tile tile = app.getGameWindow().getDraggedTile().getTile();
			if(tile == null){
				System.err.print("BullpenController::mouseRealeased");
			}
			else
			{
				bp.addTile(tile);
				app.getGameWindow().releaseDraggedTile();
				app.getGameWindow().revalidate();
				app.getGameWindow().repaint();
			}
				
				
			//LevelAchievementMonitor AM = m.getCurrentAM();
			IMove move = new TileToBullpenMove(tile, bp);
	//			if(move.doMove(app)){
	//				if(AM.updateAchievement_releaseonbullpen()){
	//					AM.popUpScreen();
	//				}
	//			}else{
	//				if(AM.updateAchievement_wheninvalidmove()){
	//					AM.popUpScreen();
	//				}
	//			}
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
