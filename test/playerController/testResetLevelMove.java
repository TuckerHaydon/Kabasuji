package playerController;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class testResetLevelMove {

	@Test
	public void testPuzzle() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup puzzle level
		gm.setCurrentLevel(0);
		
		//create the move
		ResetLevelMove rlm = new ResetLevelMove(player, gm);
		
		//after a level is reset, there should be 0 pieces on the board
		rlm.doMove();
		assertEquals(gm.getCurrentLevel().getBoard().getTiles().size(), 0);
		
		assertTrue(rlm.undo());
		
	}
	
}
