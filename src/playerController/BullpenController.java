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
	
	public BullpenController(KabasujiPlayerApplication app, GameModel m, Bullpen bp){
		this.bp = bp;
		this.app = app;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		System.out.println("Bullpen Pressed");
		
		int x = me.getX();
		int y = me.getY();
		
		int cellNum;
		
		//determine if a tile is there
		//set that tile view to dragged
	}
	
	@Override
	public void mouseReleased(MouseEvent me){
		
		//release drag tile goes there
		
		Tile tile = app.getGameWindow().getDraggedTile().getTile();
		if(tile==null){
			System.err.print("BullpenController::mouseRealeased");
		}
		
		
		LevelAchievementMonitor AM = m.getCurrentAM();
		IMove move = new TileToBullpenMove(tile, bp);
			if(move.doMove(app)){
				if(AM.updateAchievement_whenclickbullpen()){
					AM.popUpScreen();
				}
			}else{
				if(AM.updateAchievement_wheninvalidmove()){
					AM.popUpScreen();
				}
			}
	}
	
}
