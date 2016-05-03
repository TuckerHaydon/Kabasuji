package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;

/**
 * Handles navigation to the achievement menu
 * @author tuckerhaydon
 *
 */
public class NavigateAchievementMenu implements ActionListener {
	
	KabasujiPlayerApplication app;
	
	/**
	 * Constructor for navigate achievement menu
	 * @param app - top level Kabasuji player application
	 */
	public NavigateAchievementMenu(KabasujiPlayerApplication app){
		this.app = app;
	}
	
	/**
	 * Shows all unlocked achievements upon navigation
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		app.displayAchievementsMenu();
	}

}
