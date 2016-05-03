/**
 * 
 */
package builderController;

import static org.junit.Assert.*;

import org.junit.Test;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * @author kacper
 *
 */
public class testSetters {

	@Test
	public void test() {
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication game = new KabasujiBuilderApplication(m);
		game.init();
		//game.displaySplashScreen();
		game.displayLevelEditor();
		
		SetBoardEltNumMove sbenm = new SetBoardEltNumMove(game, m, 2);
		assertTrue(sbenm.execute());
		assertTrue(sbenm.executeUndo());
		
		SetBoardEltTypeMove sbetm = new SetBoardEltTypeMove(game, m, "playable");
		assertTrue(sbetm.execute());
		assertEquals(m.getSelectedBoardEltType(),"playable");
		assertTrue(sbetm.executeUndo());
		
		SetAllowedTimeMove satm = new SetAllowedTimeMove(game, m, 12);
		assertTrue(satm.execute());
		assertEquals(m.getLevel().getlevelData(),12);
		assertTrue(satm.executeUndo());
	
		SetNumAllowedMovesMove snamm = new SetNumAllowedMovesMove(game,m,2);
		assertTrue(snamm.execute());
		assertEquals(m.getLevel().getlevelData(),2);
		assertTrue(snamm.executeUndo());
		
		SetHintMove shm = new SetHintMove(game,m,true);
		assertTrue(shm.execute());
		assertEquals(m.isHintSelected(),true);
		assertFalse(shm.executeUndo());
		
		SetBoardEltColorMove sbecm = new SetBoardEltColorMove(game,m,"red");
		assertTrue(sbecm.execute());
		assertEquals(m.getSelectedColor(),"red");
		assertTrue(sbecm.executeUndo());
	}
}
