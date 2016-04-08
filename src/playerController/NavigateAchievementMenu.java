package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.PlayerLauncher;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class NavigateAchievementMenu implements ActionListener {
	
	KabasujiPlayerApplication app;
	
	public NavigateAchievementMenu(KabasujiPlayerApplication app){
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.displayAchievementsMenu();
	}

}
