package playerEntity;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;

public class testGameAchievementMonitor {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup release level
		gm.setCurrentLevel(2);
		
		GameAchievementMonitor gam = new GameAchievementMonitor(gm.getAchievements());
		gam.setRunningLevel(2);
		
		//"beat" the level twice
		gam.updateAchievement(3);
		gam.updateAchievement(3);
		
		//now check that "Victory Lap" achievement is earned
		assertTrue(gm.getAchievements().get("VictoryLap").getIsEarned());
		
		//now go to (and complete) the next two levels
		gam.setRunningLevel(3);
		gam.updateAchievement(4);
		gam.setRunningLevel(4);
		gam.updateAchievement(5);
		
		//now check that "K-kombo breaker" achievement is earned
		assertTrue(gm.getAchievements().get("K-komboBreaker").getIsEarned());
		
		//finally reset the level
		gam.reset();
	}

}
