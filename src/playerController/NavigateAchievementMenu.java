package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;

/**
 * 
 * @author tuckerhaydon
 *
 */
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
