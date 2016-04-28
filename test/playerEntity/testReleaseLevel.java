package playerEntity;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;

public class testReleaseLevel {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup release level
		gm.setCurrentLevel(2);
		
		ReleaseLevel currentLevel = (ReleaseLevel) gm.getCurrentLevel();
		
		currentLevel.getBoard();
		currentLevel.getBullpen();
		currentLevel.getIsCompleted();
		currentLevel.getIsUnlocked();
		currentLevel.getLevelData();
		currentLevel.getNumLeft();
		currentLevel.getStars();
	}

}
