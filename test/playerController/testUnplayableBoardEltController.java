package playerController;

import static org.junit.Assert.*;

import java.awt.event.MouseEvent;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.GameModel;

public class testUnplayableBoardEltController {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//load up the first level, set a tile to be dragged
		gm.setCurrentLevel(0);
		gm.selectCurrentAM(1);
		TileView tv = new TileView(player, gm, gm.getCurrentLevel().getBullpen().getTiles().get(0));
		player.getGameWindow().setDraggedTile(tv);
		
		UnplayableBoardEltController ubec = new UnplayableBoardEltController(player, player.getGameWindow(), gm);
		
		MouseEvent me = new MouseEvent(tv, 0, 0, 0, 0, 0, 0, false);
		ubec.mouseDragged(me);
		ubec.mouseReleased(me);
		assertTrue(player.getGameWindow().getDraggedTile() == null);
		
	}

}
