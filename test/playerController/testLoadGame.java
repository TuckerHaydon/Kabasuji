package playerController;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class testLoadGame {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		LoadGame lg = new LoadGame(gm, player);
		lg.getGameNames();
		lg.parseGame("src/resources/games/ExampleGame1");
		
		//the game should have levels now
		assertNotSame(player.getGameModel().getLevels(), null);
	}
	
	

}
