package playerController;

import static org.junit.Assert.*;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LevelView;
import playerBoundary.TileView;
import playerEntity.GameModel;
import playerEntity.Tile;

public class testLevelController {

	@Test
	public void testNullSelectedTile() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup puzzle level
		gm.setCurrentLevel(0);
		
		//get levelView of current level
		LevelView currLevView = player.getGameWindow().getLevelView();
		
		LevelController lc = new LevelController(player, gm, currLevView);
		lc.processMousePressed();
		lc.processMouseMoved();
	}
	
	@Test
	public void testSelectedTile() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup puzzle level
		gm.setCurrentLevel(0);
		gm.selectCurrentAM(1);
		
		//get levelView of current level
		LevelView currLevView = player.getGameWindow().getLevelView();
		
		//select a tile from the bullpen, create its tileView, make it the selected tile
		Tile selectedTile = gm.getCurrentLevel().getBullpen().getTiles().get(0);
		TileView selectedTileView = new TileView(player, gm, selectedTile);
		player.getGameWindow().setDraggedTile(selectedTileView);
		
		LevelController lc = new LevelController(player, gm, currLevView);
		lc.processMousePressed();
	}
	
	@Test
	public void testSelectedTileMouseMoved() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup puzzle level
		gm.setCurrentLevel(0);
		gm.selectCurrentAM(1);
		
		//get levelView of current level
		LevelView currLevView = player.getGameWindow().getLevelView();
		
		//select a tile from the bullpen, create its tileView, make it the selected tile
		Tile selectedTile = gm.getCurrentLevel().getBullpen().getTiles().get(0);
		TileView selectedTileView = new TileView(player, gm, selectedTile);
		player.getGameWindow().setDraggedTile(selectedTileView);
		
		LevelController lc = new LevelController(player, gm, currLevView);
		lc.processMouseMoved();
	}

}
