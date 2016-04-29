package playerBoundary;

import static org.junit.Assert.*;

import org.junit.Test;

import playerEntity.GameModel;


//tests the remaining parts of the player app that aren't touched by other test cases
//...except the splash screen
public class testKabasujiPlayerApplication {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//check that the achievements menu is displayed
		player.displayAchievementsMenu();
		assertTrue(player.getAchievementsMenu().isVisible());
		
		//now get the instructions page and make sure it is displayed
		//and the achievements menu is not
		player.displayInstructionsPage();
		assertTrue(player.getInstructionsPage().isVisible());
		assertFalse(player.getAchievementsMenu().isVisible());
	}

}
