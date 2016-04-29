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
		ram.isValid();
		assertTrue(ram.isValid());
		
		//execute the move
		ram.doMove();
		
		//test that undo always returns false
		//(why do we need this?)
		ram.undo();
		assertFalse(ram.undo());
		Achievement m = new Achievement("test");
		assertEquals(m.getIsEarned(), false);
		m.setIsEarned(true);
		gm.getAchievements().put("test", m);
		ResetAchievementController rac = new ResetAchievementController(player, gm);
		rac.actionPerformed(new ActionEvent(gm, 0, null));
		
		assertTrue(gm.getAchievements().isEmpty());
	}

}
