package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerEntity.Anchor;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LevelView;
import playerEntity.Square;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class LevelController extends MouseAdapter {

	KabasujiPlayerApplication app;
	LevelView lv;
	
	public LevelController(KabasujiPlayerApplication app, LevelView lv){
		super();
		this.app = app;
		this.lv = lv;
	}	
	
	@Override
	public void mousePressed(MouseEvent me){
		processMousePressed();
	}
	
	void processMousePressed(){
		Tile sendBack = app.getGameWindow().getDraggedTile().getTile();
		Square anchor =  sendBack.getSquare(0, 0);
		int[] anchorpos = ((Anchor) anchor).getRowCol();
		TileToBoardMove tbm = new TileToBoardMove(app.getGameModel().getCurrentLevel().getBoard(), (Anchor)anchor, anchorpos[0], anchorpos[1]);
		app.getGameWindow().releaseDraggedTile();
		tbm.doMove(app);
		
	}
	
	@Override
	public void mouseMoved(MouseEvent me){
		processMouseMoved();
	}
	
	void processMouseMoved(){
		
		// If there is no tile selected, do nothing
		if(app.getGameWindow().getDraggedTile() == null){
			return;
		}
		// If a tile is selected, move it to the mouse location
		else{
			UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove();
			move.doMove(app);
		}
	}
}

