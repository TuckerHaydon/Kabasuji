/**
 * 
 */
package playerController;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.PuzzleAchievementMonitor;
import playerEntity.Tile;

/**
 * @author kacper
 *
 */
public class TestPrematureLevelCompletion {
	
	@Test
	public void test() {
		GameModel m = GameModel.instance();
		
		KabasujiPlayerApplication app = new KabasujiPlayerApplication(m);
		m.loadGame("src/resources/games/Game 1");
		m.setCurrentLevel(0);
		PrematureCompleteLevelMove pclm = new PrematureCompleteLevelMove(app, m);
		PuzzleAchievementMonitor pam = new PuzzleAchievementMonitor(null);
		m.selectCurrentAM(1);
		
		CompleteLevelMove clm = new CompleteLevelMove(app, m);
		
		assertFalse(clm.execute());
		m.getCurrentLevel().getBoard().addTile(new Tile(1, "board"),2,0);
		m.getCurrentLevel().getBoard().addTile(new Tile(2, "board"),2,1);
		m.getCurrentLevel().getBoard().addTile(new Tile(2, "board"),2,2);
		assertEquals(3,m.getCurrentLevel().getStars());
		pclm.actionPerformed(new ActionEvent(m,0,null));
		assertTrue(m.getCurrentLevel().getIsCompleted());
	}

}
