package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * Navigate to the main menu of the game; does not trigger RageQuit
 * @author tuckerhaydon
 *
 */
public class NavigateMainMenu implements ActionListener {
	KabasujiPlayerApplication app;
	GameModel m;
	
	/**
	 * Navigate to main menu
	 * @param app - top level kabasuji player application
	 * @param m - top level game model
	 */
	public NavigateMainMenu(KabasujiPlayerApplication app, GameModel m) {
		this.app = app;
		this.m=m;
	}

	/**
	 * Process navigation
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			processAction();
	}
	
	void processAction(){		
		// Display the main menu
		app.displayMainMenu();
	}

}
