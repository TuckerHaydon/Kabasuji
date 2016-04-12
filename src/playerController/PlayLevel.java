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
	
		if(m.getLevels()[levelNum].getIsUnlocked())
		{
			app.displayGameWindow();
			m.setCurrentLevel(levelNum);
		
		GameWindow currWindow = app.getGameWindow();
		int currLN = m.getCurrentLevel().getLevelNum();
		if((currLN == 1) || (currLN == 4) || (currLN == 7) || (currLN == 10) || (currLN == 13))
		{
			PuzzleLevelView levView = new PuzzleLevelView((PuzzleLevel) m.getCurrentLevel());
			currWindow.setLevelView((PuzzleLevelView) levView);
			//currWindow.add(levView);
		}
		else if((currLN == 2) || (currLN == 5) || (currLN == 8) || (currLN == 11) || (currLN == 14))
		{
			LightningLevelView levView = new LightningLevelView((LightningLevel) m.getCurrentLevel());
			currWindow.setLevelView(levView);
			//currWindow.add(levView);
		}
		else if((currLN == 3) || (currLN == 6) || (currLN == 9) || (currLN == 12) || (currLN == 15))
		{
			//ReleaseLevelView levView = new ReleaseLevelView((ReleaseLevel) m.getCurrentLevel());
			//this.add(levView);
		}
		}
		
		//app.displayGameWindow();
	}

}
