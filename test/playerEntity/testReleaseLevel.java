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
		
		//get the current level
		ReleaseLevel currentLevel = (ReleaseLevel) gm.getCurrentLevel();
		
		//get the board and bullpen
		Board b = currentLevel.getBoard();
		Bullpen bp = currentLevel.getBullpen();
		
		//unlocked by default
		assertTrue(currentLevel.getIsUnlocked());
		
		//check that setIsUnlocked works
		currentLevel.setIsUnlocked(false);
		assertFalse(currentLevel.getIsUnlocked());
		
		//none covered by default
		assertEquals(0, currentLevel.getNumLeft());
		
		
		//should be false by default
		assertFalse(currentLevel.getIsCompleted());
		
		//no stars by default
		assertEquals(0,currentLevel.getStars());
		
		//check that reset works
		currentLevel.reset();
		
		//not sure what to test for these methods, but running them anyway
		currentLevel.toString();
		currentLevel.cannotContinue();
		currentLevel.getLevelData();
		currentLevel.getNumLeft();
		
	}

}
