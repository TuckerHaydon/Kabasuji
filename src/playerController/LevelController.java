package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerEntity.Anchor;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LevelView;
import playerEntity.GameModel;
import playerEntity.Tile;

public class LevelController extends MouseAdapter {

	KabasujiPlayerApplication app;
	LevelView lv;
	
	public LevelController(KabasujiPlayerApplication app, LevelView lv){
		super();
		this.app = app;
		this.lv = lv;
	}	
	
	
	//@Override
	public void mouseDragged(MouseEvent me) {
		
		app.getGameWindow().getDraggedTile().setLocation(me.getX(), me.getY());
		app.getGameWindow().displayDraggedTile();
		
	}
	
	public void mouseReleased(MouseEvent me){
		Tile sendBack = app.getGameWindow().getDraggedTile().getTile();
		Anchor anchor = (Anchor) sendBack.getSquare(0, 0);
		int[] anchorpos = anchor.getRowCol();
		TileToBoardMove tbm = new TileToBoardMove(app.getGameModel().getCurrentLevel().getBoard(), anchor, anchorpos[0], anchorpos[1]);
		app.getGameWindow().releaseDraggedTile();
		if(tbm.isValid(app)){
			tbm.doMove(app);
		}
		
	}
}

