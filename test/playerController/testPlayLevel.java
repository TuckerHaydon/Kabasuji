package playerController;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class testPlayLevel {

	@Test
	public void test() {
		KabasujiPlayerApplication player = new KabasujiPlayerApplication();
		GameModel gm = player.getGameModel();
		player.init();
		
		NavigateLevelSelectionMenu nlsm = new NavigateLevelSelectionMenu(player);
		PlayLevel pl = new PlayLevel(player, gm, 1); 
		player.displayGameWindow();
	}
	

}
