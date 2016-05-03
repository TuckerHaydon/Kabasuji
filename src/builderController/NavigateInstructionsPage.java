package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

public class NavigateInstructionsPage implements ActionListener{

	KabasujiBuilderApplication app;
	
	public NavigateInstructionsPage(KabasujiBuilderApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
		
	}
	
	void processAction(){
		app.displayInstructionsPage();
	}
	
	
}
