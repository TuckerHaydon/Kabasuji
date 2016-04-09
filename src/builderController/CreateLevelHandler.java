package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

public class CreateLevelHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	
	public CreateLevelHandler(KabasujiBuilderApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO clear the level builder and stuff
		app.displayLevelEditor();
	}

}
