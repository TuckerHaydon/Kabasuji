package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.PuzzleLevelView;
import playerBoundary.TileView;
import playerEntity.Anchor;
import playerEntity.Board;
import playerEntity.GameModel;
import playerEntity.LightningLevel;
import playerEntity.PlayableBoardElt;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;
import playerEntity.Square;
import playerEntity.Tile;

/**
 * 
 * @author tuckerhaydon, ndiwakar, dgwalder
 *
 */
public class PickUpTileBoardMove extends Move{
	
	Tile tile;
	Board board;
	int[] rowcol;
	
	public PickUpTileBoardMove(KabasujiPlayerApplication app, GameModel m, Tile tile, Board board){
		super(app, m);
		this.tile=tile;
		this.board=board;
	}
	
	@Override
	boolean doMove() {
		
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
		TileView tv = new TileView(app, m, tile);
		app.getGameWindow().setDraggedTile(tv);
		
		// Update the GUI to show the picked up tile
		UpdateDraggedTileLocationMove move = new UpdateDraggedTileLocationMove(app, m);
		move.execute();
		
		// Repaint the board
		app.getGameWindow().getLevelView().getBoardView().repaint();
		
		//update puzzle level moves and repaint the label
		if (m.getCurrentLevel() instanceof PuzzleLevel){
			((PuzzleLevel) m.getCurrentLevel()).updateMoves(-1);
			((PuzzleLevelView) app.getGameWindow().getLevelView()).refreshLabels();
		}
		
		return true;
	}
	
	@Override
	public boolean undo() {
		return board.addTile(tile, rowcol[0], rowcol[1]);
	}

	@Override
	boolean isValid() {
		if(m.getCurrentLevel() instanceof LightningLevel || m.getCurrentLevel() instanceof ReleaseLevel) {
			return false;
		}
		return true;
	}

}
