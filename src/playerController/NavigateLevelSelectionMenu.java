package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * Navigate to the level selection menu
 * @author tuckerhaydon
 *
 */
public class NavigateLevelSelectionMenu implements ActionListener{
	
	KabasujiPlayerApplication app;
	GameModel m;
	
	/**
	 * Constructor for navigating to level selection menu
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 */
	public NavigateLevelSelectionMenu(KabasujiPlayerApplication app,GameModel m) {
		this.app = app;
		this.m=m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!m.IsTesting()){
			app.displayLevelSelectionMenu();
		}
	}

}
