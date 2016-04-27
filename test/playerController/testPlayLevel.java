package playerController;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class testPlayLevel {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		player.init();
		
		NavigateLevelSelectionMenu nlsm = new NavigateLevelSelectionMenu(player, gm);
		PlayLevel pl = new PlayLevel(player, gm, 1); 
		player.displayGameWindow();
	}
	

}
