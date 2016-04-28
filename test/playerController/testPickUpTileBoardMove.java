package playerController;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Board;
import playerEntity.GameModel;
import playerEntity.PuzzleAchievementMonitor;
import playerEntity.Tile;

public class testPickUpTileBoardMove {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup
		gm.setCurrentLevel(0);
		
		//get entities
		Board b = gm.getCurrentLevel().getBoard();
		ArrayList<Tile> allTiles = gm.getCurrentLevel().getBullpen().getTiles();
		Tile selectTile = allTiles.get(3);
		
		//get boundaries
		TileView tv = new TileView(player, gm, selectTile);
		
		//first have to add a tile to the board
		PuzzleAchievementMonitor pam = new PuzzleAchievementMonitor(null);
		gm.selectCurrentAM(1);
		TileToBoardMove ttbm = new TileToBoardMove(player, gm, b, allTiles.get(3), 2, 2);
		ttbm.setAM(pam);
		player.getGameWindow().setDraggedTile(tv);
		ttbm.execute();
		
		//now pick up that tile on the board
		PickUpTileBoardMove putbm = new PickUpTileBoardMove(player, gm, selectTile, b);
		
		//check if valid
		putbm.isValid();
		assertTrue(putbm.isValid());
		
		//now do the move, and verify that there is no tiles on the board
		putbm.execute();
		assertEquals(gm.getCurrentLevel().getBoard().getTiles().size(), 0);
		
		//verify that the dragged tile is the tile that was picked up
		assertSame(player.getGameWindow().getDraggedTile().getTile(), selectTile);
		
		//now undo and verify that there is one tile on the board
		putbm.undo();
		assertEquals(gm.getCurrentLevel().getBoard().getTiles().size(), 1);
		
	}

}
