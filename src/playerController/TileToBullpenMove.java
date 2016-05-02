package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.PuzzleLevelView;
import playerEntity.Anchor;
import playerEntity.Bullpen;
import playerEntity.GameModel;
import playerEntity.LevelAchievementMonitor;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;
import playerEntity.Tile;

/**
 * Adds a Tile to the Bullpen 
 * @author tuckerhaydon, dgwalder, kacper puczydlowski
 *
 */
public class TileToBullpenMove extends Move{
	Tile tile;
	Bullpen bullpen;
	LevelAchievementMonitor AM;
	
	public TileToBullpenMove(KabasujiPlayerApplication app, GameModel m, Tile tile, Bullpen bullpen){
		super(app, m);
		this.tile=tile;
		this.bullpen=bullpen;
	}
	
	@Override 
	public boolean execute(){
		
		
		if(!this.isValid()){
			return false;
		}
		
		return this.doMove();
	}
	
	/**
	 * Return a tile to the bullpen
	 */
	@Override
	boolean doMove() {
		
		// Add the tile to the bullpen
		boolean successful = bullpen.addTile(tile);
		
		if(!successful){
			return false;
		}
		
		//update puzzle level moves
		if (m.getCurrentLevel() instanceof PuzzleLevel && tile.getLocation().equals("board")){
			((PuzzleLevel) m.getCurrentLevel()).updateMoves(+1);
			((PuzzleLevelView) app.getGameWindow().getLevelView()).refreshMoveLabel();
		}
		
		tile.setLocation("bullpen");
		
		// Release the dragged tile
		app.getGameWindow().releaseDraggedTile();
		
		// Repaint the bullpen
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		

		AM = m.getCurrentAM();
		
		if(AM.updateAchievement_releaseonbullpen()){
			AM.popUpScreen();
		}
		
		return successful;
	}

	@Override
	boolean isValid() {
		if(m.getCurrentLevel() instanceof LightningLevel || app.getGameWindow().getDraggedTile()==null) {
			return false;
		}
		return true;
	}
	
	public boolean undo() {
		bullpen.removeTile(tile);
		m.getCurrentLevel().getBoard().addTile(tile,
				((Anchor)tile.getSquare(0,0)).getRowCol()[0],((Anchor)tile.getSquare(0,0)).getRowCol()[1]);
		return true;
	}
}
