package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

public class NavigateLevelEditorMenu implements ActionListener {
	
	KabasujiBuilderApplication app;
	
	public NavigateLevelEditorMenu(KabasujiBuilderApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.displayLevelEditorMenu();
	}

}
