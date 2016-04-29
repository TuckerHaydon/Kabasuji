package playerBoundary;

import static org.junit.Assert.*;

import org.junit.Test;

import playerEntity.GameModel;
import playerEntity.ReleaseLevel;

public class testReleaseLevelView {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup release level
		gm.setCurrentLevel(2);
		ReleaseLevel rl = (ReleaseLevel)gm.getCurrentLevel();
		
		//initialize the view
		ReleaseLevelView rlv = new ReleaseLevelView(player, gm, rl); 
		rlv.initView();
		rlv.initControllers();
		
		//ensure that it properly initializes board and bullpen views
		assertTrue(rlv.getBoardView() != null);
		assertTrue(rlv.getBullpenView() != null);
	}

}
