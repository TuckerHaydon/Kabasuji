package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

/**
 * navigates to level editor menu in the builder application
 * @author tuckerhaydon
 *
 */
public class NavigateLevelEditorMenu implements ActionListener {
	
	KabasujiBuilderApplication app;
	
	/**
	 * NavigateLevelEditorMenu constructor
	 * @param app
	 */
	public NavigateLevelEditorMenu(KabasujiBuilderApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.displayLevelEditorMenu();
	}

}
