package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

/**
 * Navigate to the level editor menu
 * @author tuckerhaydon
 *
 */
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
