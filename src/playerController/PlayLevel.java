package playerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import playerBoundary.GameWindow;
import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LightningLevelView;
import playerBoundary.PuzzleLevelView;
import playerBoundary.ReleaseLevelView;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class PlayLevel implements ActionListener {

	KabasujiPlayerApplication app;
	GameModel m;
	int levelNum;

	public PlayLevel(KabasujiPlayerApplication app, GameModel m, int ln){
		this.app = app;
		this.m = m;
		this.levelNum = ln-1; // Must subtract 1 to convert number to index
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		// Check to make sure the level you clicked on is unlocked
		if(m.getLevels()[levelNum].getIsUnlocked())
		{	
			// Update the current level
			m.setCurrentLevel(levelNum);
			//before play the level reset the level first
			m.getCurrentLevel().reset();
			
			// Update the level view panel in the game window
			app.getGameWindow().updateView();
			
			// Display the game window
			app.displayGameWindow();
			
			//achievement stuff 
			 m.getGAM().setPreviousLevel(levelNum);
			 m.selectCurrentAM(levelNum);
			 

		}
		else
		{
			System.err.println("Level not unlocked.");
		}
		
		
		
	}

}
