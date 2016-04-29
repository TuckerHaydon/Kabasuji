package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class NavigateInstructionsMenu implements ActionListener {

	KabasujiPlayerApplication app;
	GameModel m;
	
	public NavigateInstructionsMenu(KabasujiPlayerApplication app, GameModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		app.displayInstructionsPage();
		m.getGAM().unlockWhatANerd();
		m.getGAM().pop();
	}
}
