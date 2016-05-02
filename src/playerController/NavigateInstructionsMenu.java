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
		m.getGAM().unlockWhatANerd();
//		for(long i=1000000000;i>0;i--){
//		}
		//TODO need timers help
		m.getGAM().pop();
	}
	
	void processAction(){
		app.displayInstructionsPage();
		
	}
}
