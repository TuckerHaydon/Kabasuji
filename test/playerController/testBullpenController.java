package playerController;

import java.awt.event.MouseEvent;

import org.junit.Test;

import playerBoundary.BullpenView;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.PuzzleAchievementMonitor;

//MAKE ASSERT STATEMENTS FOR THIS CLASS
public class testBullpenController {

	@Test
	public void testSelectedTile() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup
		gm.setCurrentLevel(0);
		TileView tv = new TileView(player, gm, gm.getCurrentLevel().getBullpen().getTiles().get(0));
		player.getGameWindow().setDraggedTile(tv);
		PuzzleAchievementMonitor pam = new PuzzleAchievementMonitor(null);
		gm.selectCurrentAM(1);
		
		
		//get bullpen, bullpenView
		Bullpen bp = gm.getCurrentLevel().getBullpen();
		BullpenView bpv = player.getGameWindow().getLevelView().getBullpenView();
		BullpenController bpc = new BullpenController(player, gm, bp, 100);
		
		MouseEvent meBP = new MouseEvent(bpv, 0, 0, 0, 0, 0, 0, false);
		bpc.mousePressed(meBP);
		bpc.mouseMoved(meBP);
		
		//ctrl + left click
		bpc.processMousePressed(0, 0, true, false, true, false);
		
		//ctrl + right click
		bpc.processMousePressed(0, 0, true, false, false, true);
		
		//shift + left click
		bpc.processMousePressed(0, 0, false, true, true, false);
				
		//shift + right click
		bpc.processMousePressed(0, 0, false, true, false, true);
		
	}
	
	@Test
	public void testNoSelectedTile() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup
		gm.setCurrentLevel(0);
		PuzzleAchievementMonitor pam = new PuzzleAchievementMonitor(null);
		gm.selectCurrentAM(1);
		
		
		//get bullpen, bullpenView
		Bullpen bp = gm.getCurrentLevel().getBullpen();
		BullpenView bpv = player.getGameWindow().getLevelView().getBullpenView();
		BullpenController bpc = new BullpenController(player, gm, bp, 100);
		
		MouseEvent meBP = new MouseEvent(bpv, 0, 0, 0, 0, 0, 0, false);
		bpc.mouseMoved(meBP);
	
		//ctrl + left click
		bpc.processMousePressed(0, 0, true, false, true, false);
		
		//ctrl + right click
		bpc.processMousePressed(0, 0, true, false, false, true);
		
		//shift + left click
		bpc.processMousePressed(0, 0, false, true, true, false);
				
		//shift + right click
		bpc.processMousePressed(0, 0, false, true, false, true);
		
	}

}
