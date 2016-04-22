package playerController;

import playerBoundary.KabasujiPlayerApplication;
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
		rowcol = ((Anchor) tile.getSquare(0, 0)).getRowCol();
		if(isValid(app)){
			board.removeTile(tile);
		}
		return false;
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
