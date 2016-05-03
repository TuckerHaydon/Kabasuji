package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LightningLevelView;
import playerBoundary.PuzzleLevelView;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;

/**
 * Handles all of the level data activity during a level reset
 * @author 
 *
 */
public class ResetLevelMove extends Move{
	int[] data;
	
	public ResetLevelMove(KabasujiPlayerApplication app, GameModel m){
		super(app, m);
		data = new int[2]; // Contains the score and the level-specific data
	}
	
	/**
	 * Reset the level, every tile goes back to where it was 
	 */
	@Override
	boolean doMove() {
		// Get the current level
		if(!isValid()) return false;
		Level l = m.getCurrentLevel();
		
		if(app.getGameWindow().getDraggedTile()!=null){
			app.getGameWindow().releaseDraggedTile();
		}
		
		// Store the level-specific data
		data[1] = l.getLevelData();
		
		// Reset the level
		m.getCurrentLevel().reset();
		
		// Update the UI
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		app.getGameWindow().getLevelView().getBoardView().repaint();
		app.getGameWindow().getLevelView().refreshProgressBar();
		
		if(m.getCurrentLevel() instanceof PuzzleLevel){
			((PuzzleLevelView) app.getGameWindow().getLevelView()).refreshMoveLabel();
		}else if(m.getCurrentLevel() instanceof LightningLevel){
			((LightningLevelView) app.getGameWindow().getLevelView()).refreshTimeLabel();
		}
		
		return true;
	}
	
	@Override
	boolean isValid() {
		// Can always reset
		return true;
	}
	
	@Override
	public boolean undo() {
		
		// Get the current level
		Level l = m.getCurrentLevel();
		
		
		// Set the level-specific data back
		l.setLevelData(data[1]);
		
		return true;
	}

}
