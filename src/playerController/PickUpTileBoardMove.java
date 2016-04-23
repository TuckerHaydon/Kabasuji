package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.TileView;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.PlayableBoardElt;
import playerEntity.ReleaseLevel;
import playerEntity.Square;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon
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
		
		// rowcol of anchor for undo purposes
		rowcol = ((Anchor) tile.getSquare(0, 0)).getRowCol();
		
		// Remove the tile from the board
		board.removeTile(tile);
		
		// Set all of the covered elts to uncovered
		for(Square s: tile.getSquares()){
			
			int row = tile.getAnchor().getRowCol()[0] - s.getRelY();
			int col = tile.getAnchor().getRowCol()[1] + s.getRelX();
			
			PlayableBoardElt elt = (PlayableBoardElt)board.getBoardElt(row, col);
			
			elt.setCovered(false);
		}
		
		// Update the dragged tile view
		TileView tv = new TileView(tile);
		app.getGameWindow().setDraggedTile(tv);
		
		// Update the GUI to show the picked up tile
		UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove();
		move.doMove(app);
		
		// Repaint the board
		app.getGameWindow().getLevelView().getBoardView().repaint();
		
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		return board.addTile(tile, rowcol[0], rowcol[1]);
	}

	/*you can always pick it up from board*/
	public boolean isValid(KabasujiPlayerApplication app) {
		if(app.getGameModel().getCurrentLevel() instanceof ReleaseLevel) {
			return false;
		}
		return true;
	}

}
