package playerController;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Achievement;
import playerEntity.GameModel;

public class testResetAchievementMove {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		ResetAchievementMove ram = new ResetAchievementMove(player, gm, gm.getAchievements());
		
		//check that the move is valid
		gm.setCurrentLevel(1);
		ram.isValid();
		assertTrue(ram.isValid());
		
		//execute the move
		ram.doMove();
		
		//test that undo always returns false
		//(why do we need this?)
		ram.undo();
		assertFalse(ram.undo());

		ResetAchievementController rac = new ResetAchievementController(player, gm);
		rac.actionPerformed(new ActionEvent(gm, 0, null));
		
		assertFalse(gm.getAchievements().get("BabySteps").getIsEarned());
	}

}
