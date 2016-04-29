package playerController;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.GameModel;
import playerEntity.PuzzleAchievementMonitor;

public class testGameWindowNavigateMainMenu {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		gm.setCurrentLevel(0);
		gm.selectCurrentAM(1);
		
		GameWindowNavigateMainMenu gwnmm = new GameWindowNavigateMainMenu(player, gm);
		gwnmm.processAction();
		gwnmm.playCatScreech();
		
		//now you should have rage quit achievement
		assertTrue(gm.getAchievements().get("RageQuit").getIsEarned());
	}

}
