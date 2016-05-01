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
		for(long i=1000000000;i>0;i--){
		}
		m.getGAM().pop();
	}
}
