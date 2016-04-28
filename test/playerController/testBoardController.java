package playerController;

import static org.junit.Assert.*;

import java.awt.event.MouseEvent;

import org.junit.Test;

import playerBoundary.BoardView;
import playerBoundary.BullpenView;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Board;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.PuzzleAchievementMonitor;

//NEEDS ASSERT STATEMENTS
public class testBoardController {

	@Test
	public void test() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		//setup
		gm.setCurrentLevel(0);
		TileView tv = new TileView(player, gm, gm.getCurrentLevel().getBullpen().getTiles().get(0));
		player.getGameWindow().setDraggedTile(tv);
		PuzzleAchievementMonitor pam = new PuzzleAchievementMonitor(null);
		gm.selectCurrentAM(1);
		
		
		//get board, boardView, boardController
		Board b = gm.getCurrentLevel().getBoard();
		BoardView bv = player.getGameWindow().getLevelView().getBoardView();
		BoardController bc = new BoardController(player, gm, b, 100);
		MouseEvent meBP = new MouseEvent(bv, 0, 0, 0, 0, 0, 0, false);
		bc.mousePressed(meBP);
		bc.mouseMoved(meBP);
		
		//ctrl + left click
		bc.processMousePressed(0, 0);
		
		
	}

}
