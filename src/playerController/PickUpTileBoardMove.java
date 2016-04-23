package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.Bullpen;
import playerEntity.LightningLevel;
import playerEntity.ReleaseLevel;
import playerEntity.Tile;

/**
 * 
 * @author 
 *
 */
public class PickUpTileBoardMove implements IMove{
	Tile tile;
	Board board;
	int[] rowcol;
	
	public PickUpTileBoardMove(Tile tile, Board board){
		this.tile=tile;
		this.board=board;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		
		if(!this.isValid(app)){
			return false;
		}
		
		rowcol = ((Anchor) tile.getSquare(0, 0)).getRowCol();
		board.removeTile(tile);
		
		// Update the dragged tile view
		TileView tv = new TileView(tile);
		app.getGameWindow().setDraggedTile(tv);
		
		// Repaint the board
		app.getGameWindow().getLevelView().getBoardView().repaint();
		
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		return board.addTile(tile, rowcol[0], rowcol[1]);
	}

	/*you can always pick it up from board*/
	public boolean isValid(KabasujiPlayerApplication app) {
		if(!(app.getGameModel().getCurrentLevel() instanceof ReleaseLevel)) {
			return false;
		}
		return true;
	}

}
