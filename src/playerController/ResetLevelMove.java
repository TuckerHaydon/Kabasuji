package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;

/**
 * 
 * @author 
 *
 */
public class ResetLevelMove implements IMove{
	KabasujiPlayerApplication app;
	GameModel m;
	int[] data;
	
	public ResetLevelMove(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
		data = new int[2]; // Containts the score and the level-specific data
	}

	public boolean doMove(KabasujiPlayerApplication app) {
		
		// Validate the move
		if(!this.isValid(app)){
			return false;
		}
		
		// Get the current level
		Level l = m.getCurrentLevel();
		
		// Store the score in case of undo
		data[0] = l.getScore();
		
		// Store the level-specific data
		data[1] = l.getLevelData();
		
		// Reset the level
		m.getCurrentLevel().reset();
		
		// Update the UI
		app.getGameWindow().getLevelView().getScrollPane().repaint();
		app.getGameWindow().getLevelView().getBoardView().repaint();
		
		return true;
	}
	
	public boolean isValid(KabasujiPlayerApplication app) {
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		Level l = m.getCurrentLevel();
		l.setScore(data[0]);
		if(l instanceof LightningLevel) {
			((LightningLevel) l).setUsedTime(data[1]);
			return true;
		} else if(l instanceof ReleaseLevel) {
			((ReleaseLevel) l).setNumLeft(data[1]);
			return true;
		} else {
			((PuzzleLevel) l).setUsedMoves(data[1]);
			return true;
		} 
	}

}
