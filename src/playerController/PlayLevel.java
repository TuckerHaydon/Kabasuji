package playerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * Play the level
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
		processAction();
	}
	
	/**
	 * Set current level to be the level that correspond with the level button Player clicked
	 */
	void processAction(){
		// Check to make sure the level you clicked on is unlocked
		if(m.getLevels()[levelNum].getIsUnlocked()){	
			// Update the current level
			m.setCurrentLevel(levelNum);
			
			// Update the level view panel in the game window
			app.getGameWindow().updateView();
			
			//before play the level reset the level first
			m.getCurrentLevel().reset();
			
			// Display the game window
			app.displayGameWindow();
			
			//achievement stuff 
			 m.getGAM().setRunningLevel(levelNum);
			 m.selectCurrentAM(levelNum);
		}
		else{
			System.err.println("Level not unlocked.");
		}
	}

}
