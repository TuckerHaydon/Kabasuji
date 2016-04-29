package playerController;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.LightningLevel;

//WHY ISNT THIS ONE WORKING
public class testTimerHandler {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup lightning level
		gm.setCurrentLevel(1);
		//gm.selectCurrentAM(2);
		
		TimerHandler th = new TimerHandler((LightningLevel)gm.getCurrentLevel(), player, gm);
		//th.processAction();
		
	}

}
