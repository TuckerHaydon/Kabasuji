package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

public class CreateGameHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	
	public CreateGameHandler(KabasujiBuilderApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Build game and stuff
		app.displayGameEditor();
		
	}

}
