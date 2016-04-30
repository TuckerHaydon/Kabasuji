/**
 * 
 */
package playerController;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * @author kacper
 *
 */
public class TestTileRotateMirrorMoves {
	
	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup
		gm.loadGame("src/resources/games/ExampleGame1");
		gm.setCurrentLevel(0);
		
		RotateTileClockwiseMove rtcw = new RotateTileClockwiseMove(player, gm, gm.getCurrentLevel().getBullpen().getTiles().get(0));
		RotateTileCounterClockwiseMove rtccw= new RotateTileCounterClockwiseMove(player, gm, gm.getCurrentLevel().getBullpen().getTiles().get(0));
		MirrorTileVerticalMove mtv = new MirrorTileVerticalMove(player, gm, gm.getCurrentLevel().getBullpen().getTiles().get(0));
		MirrorTileHorizontalMove mth = new MirrorTileHorizontalMove(player, gm, gm.getCurrentLevel().getBullpen().getTiles().get(0));
		
		assertTrue(rtcw.execute());
		assertTrue(rtccw.execute());
		assertTrue(mtv.execute());
		assertTrue(mth.execute());
		assertTrue(rtcw.undo());
		assertTrue(rtccw.undo());
		assertTrue(mtv.undo());
		assertTrue(mth.undo());
	}

}
