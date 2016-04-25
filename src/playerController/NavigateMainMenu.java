package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.LightningLevel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class NavigateMainMenu implements ActionListener {
	KabasujiPlayerApplication app;
	GameModel m;
	
	public NavigateMainMenu(KabasujiPlayerApplication app, GameModel m) {
		this.app = app;
		this.m=m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){		
		// Display the main menu
		app.displayMainMenu();
	}

}
