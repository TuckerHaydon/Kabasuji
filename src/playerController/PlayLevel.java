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
		this.levelNum = ln;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if(m.getLevels()[levelNum].getIsUnlocked())
		{
			app.displayGameWindow();
			m.setCurrentLevel(levelNum + 1);
		
		GameWindow currWindow = app.getGameWindow();
		if(m.getCurrentLevel().getLevelNum() % 3 == 1)
		{
			PuzzleLevelView levView = new PuzzleLevelView((PuzzleLevel) m.getCurrentLevel());
			levView.initView();
			currWindow.setLevelView((PuzzleLevelView) levView);
		}
		else if(m.getCurrentLevel().getLevelNum() % 3 == 2)
		{
			LightningLevelView levView = new LightningLevelView((LightningLevel) m.getCurrentLevel());
			currWindow.setLevelView(levView);
		}
		else if(m.getCurrentLevel().getLevelNum() % 3 == 0)
		{
			//ReleaseLevelView levView = new ReleaseLevelView((ReleaseLevel) m.getCurrentLevel());
			//this.add(levView);
		}
		}
		
		//app.displayGameWindow();
	}

}
