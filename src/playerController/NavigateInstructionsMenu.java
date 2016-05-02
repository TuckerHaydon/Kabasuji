package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * Handles navigation to the instructions menu
 * @author tuckerhaydon
 *
 */
public class NavigateInstructionsMenu implements ActionListener {

	KabasujiPlayerApplication app;
	GameModel m;
	
	/**
	 * Constructor for instructions menu navigator
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 */
	public NavigateInstructionsMenu(KabasujiPlayerApplication app, GameModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
		m.getGAM().unlockWhatANerd();
		m.getGAM().pop();
	}
	
	void processAction(){
		app.displayInstructionsPage();
		
	}
}
