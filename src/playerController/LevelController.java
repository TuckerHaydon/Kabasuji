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
	
	@Override
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
	
	@Override
	public void mouseMoved(MouseEvent me){
		
		if(app.getGameWindow().getDraggedTile() == null){
			return;
		}
		else{
			double mouseLocationX = app.getGameWindow().getMousePosition().getX();
			double mouseLocationY = app.getGameWindow().getMousePosition().getY();
			
			int centerLocationX = (int)(mouseLocationX - 3.5*app.getGameWindow().getDraggedTile().getSquareWidth());
			int centerLocationY = (int)(mouseLocationY - 4*app.getGameWindow().getDraggedTile().getSquareWidth());
					
			app.getGameWindow().getDraggedTile().setLocation(centerLocationX, centerLocationY);
			app.getGameWindow().displayDraggedTile();
		}
		
		
	}
}

