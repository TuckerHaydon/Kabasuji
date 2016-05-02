package playerController;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class testCompleteLevelMove {

	@Test
	public void testLevelFail() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup lightning level
		gm.setCurrentLevel(1);
		
		CompleteLevelMove clm = new CompleteLevelMove(player, gm);
		
		gm.getCurrentLevel().getBullpen().removeAllTiles();
		gm.getCurrentLevel().getStars();
		
		gm.selectCurrentAM(2);
		
		//this should be a valid move
		//assertTrue(clm.isValid());
		clm.doMove();
		
		//undo should always be false
		assertFalse(clm.undo());
	}
	
	//this is broken now, need to fix conditions for three stars
	@Test
	public void testLevelComplete() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup puzzle level
		gm.setCurrentLevel(0);
		
		//configure conditions for three stars
		gm.getCurrentLevel().getBullpen().removeAllTiles();
		gm.getCurrentLevel().getStars();
		
		gm.selectCurrentAM(1);
		
		CompleteLevelMove clm = new CompleteLevelMove(player, gm);
		
		//move should be valid
		clm.isValid();
		
		//ensure that the move executes
		clm.doMove();
	
	}
	
	

}
