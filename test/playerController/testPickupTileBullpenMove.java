package playerController;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.Tile;

//ASSERT STATEMENTS KINDA JANKY, COME BACK TO THIS ONE
public class testPickupTileBullpenMove {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup
		gm.loadGame("src/resources/games/ExampleGame1");
		gm.setCurrentLevel(0);
		gm.selectCurrentAM(1);
		
		//get entities
		Bullpen bp = gm.getCurrentLevel().getBullpen();
		ArrayList<Tile> allTiles = gm.getCurrentLevel().getBullpen().getTiles();
		Tile selectTile = allTiles.get(2);
		
		//get boundaries
		TileView tv = new TileView(player, gm, selectTile);
		
		//pick up a tile
		PickUpTileBullpenMove putbm = new PickUpTileBullpenMove(player, gm, selectTile, bp);
		player.getGameWindow().setDraggedTile(tv);
		
		//before the move, there is 4 tiles in the bullpen

		//assertEquals(3, bp.getTiles().size());
		assertEquals(35, bp.getTiles().size());

		
		//this is a valid move
		assertTrue(putbm.isValid());
		
		//after the move, there is only three tiles in the bullpen
		putbm.doMove();
		assertEquals(34, bp.getTiles().size());

		//after undo, there should be 4 tiles once again and no selected tile
		putbm.undo();
		assertEquals(35, bp.getTiles().size());
		
	}

}
