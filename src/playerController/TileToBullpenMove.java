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
 * 
 * @author tuckerhaydon, dgwalder
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
		
		AM = m.getCurrentAM();
		
		if(!this.isValid()){
			if(AM.updateAchievement_wheninvalidmove()){
				AM.popUpScreen();
			}
			return false;
		}
		
		return this.doMove();
	}
	
	@Override
	boolean doMove() {
		
		// Add the tile to the bullpen
		boolean successful = bullpen.addTile(tile);
		
		// Release the dragged tile
		app.getGameWindow().releaseDraggedTile();
		
		// Repaint the bullpen
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		
		if(AM.updateAchievement_releaseonbullpen()){
			AM.popUpScreen();
		}
		
		return successful;
	}

	@Override
	boolean isValid() {
		if(m.getCurrentLevel() instanceof LightningLevel) {
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
