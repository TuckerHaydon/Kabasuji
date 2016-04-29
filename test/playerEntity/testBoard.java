package playerEntity;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;

public class testBoard {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup release level
		gm.setCurrentLevel(0);
		
		//get the board and bullpen
		Board b = gm.getCurrentLevel().getBoard();
		Bullpen bp = gm.getCurrentLevel().getBullpen();
		
		//now get a tile from the bullpen and place it on the board
		Tile selectedTile = bp.getTiles().get(2);
		TileView tv = new TileView(player, gm, selectedTile);
		player.getGameWindow().setDraggedTile(tv);
		b.addTile(selectedTile, 1, 1);
		
		//now there should be exactly one tile on the board
		assertEquals(1,b.getTiles().size());
		
		//check that the tile covers boardElts
		BoardElt[][] bElts = b.getBoardElts();
		assertTrue(((PlayableBoardElt) bElts[1][1]).getCovered());
		
		//get the tile that you just placed on the board
		b.getTile(1, 1);

		//test both ways to remove it
		b.removeTile(selectedTile);
		b.removeAll();
		
		//now there should be no tiles on the board
		assertEquals(0,b.getTiles().size());
		
		//now make sure reset works
		b.reset();
		b.toString();
		
	}

}
