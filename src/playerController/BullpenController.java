package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
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
		//create tileview
		//set that tile view to dragged
		//take tile out of array list
	}
	
	@Override
	public void mouseReleased(MouseEvent me){
		
		//release drag tile goes there
		//gamewindow dragged tile = null
		//pull tile out of that dragged tile 
		//*got to bullpenview and add argument
		//add tile to array list
		
		Tile tile = app.getGameWindow().getDraggedTile().getTile();
		if(tile==null){
			System.err.print("BullpenController::mouseRealeased");
		}
		
		
		LevelAchievementMonitor AM = m.getCurrentAM();
		IMove move = new TileToBullpenMove(tile, bp);
			if(move.doMove(app)){
				if(AM.updateAchievement_releaseonbullpen()){
					AM.popUpScreen();
				}
			}else{
				if(AM.updateAchievement_wheninvalidmove()){
					AM.popUpScreen();
				}
			}
	}
	
	@Override
	public void mouseDragged(MouseEvent me){
		//the usual - update x,y
		
	}
	
}
