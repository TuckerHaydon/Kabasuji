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
public class ResetLevelMove extends Move{
	int[] data;
	
	public ResetLevelMove(KabasujiPlayerApplication app, GameModel m){
		super(app, m);
		data = new int[2]; // Contains the score and the level-specific data
	}

	@Override
	boolean doMove() {
		
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
	
	@Override
	boolean isValid() {
		// Can always reset
		return true;
	}
	
	@Override
	public boolean undo() {
		
		// Get the current level
		Level l = m.getCurrentLevel();
		
		// Set the score back
		l.setScore(data[0]);
		
		// Set the level-specific data back
		l.setLevelData(data[1]);
		
		return true;
	}

}
