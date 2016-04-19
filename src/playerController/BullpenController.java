package playerController;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.LevelAchievementMonitor;
import playerEntity.Tile;

public class BullpenController extends MouseAdapter {
	KabasujiPlayerApplication app;
	GameModel m;
	Bullpen bp;
	int boxwidth;
	
	public BullpenController(KabasujiPlayerApplication app, GameModel m, Bullpen bp, int boxwidth){
		this.bp = bp;
		this.app = app;
		this.boxwidth = boxwidth;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		System.out.println("Bullpen Pressed");
		
		int x = me.getX();
		int y = me.getY();
		
		int cellNum = x/boxwidth;
		
		Tile pressedTile = bp.getTiles().get(cellNum);
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
	
	@Override
	public void mouseReleased(MouseEvent me){
		
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
	
	@Override
	public void mouseDragged(MouseEvent me){
		
		double mouseLocationX = app.getGameWindow().getMousePosition().getX();
		double mouseLocationY = app.getGameWindow().getMousePosition().getY();
		
		int centerLocationX = (int)(mouseLocationX - 3.5*app.getGameWindow().getDraggedTile().getSquareWidth());
		int centerLocationY = (int)(mouseLocationY - 4*app.getGameWindow().getDraggedTile().getSquareWidth());
				
		app.getGameWindow().getDraggedTile().setLocation(centerLocationX, centerLocationY);
		app.getGameWindow().displayDraggedTile();

		
	}
	
}
