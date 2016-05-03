package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

/**
 * Navigate to the Game editor menu
 * @author tuckerhaydon
 *
 */
public class NavigateGameEditorMenu implements ActionListener {
	
	KabasujiBuilderApplication app;
	
	/**
	 * NavigateGameEditorMenu constructor
	 * @param app
	 */
	public NavigateGameEditorMenu(KabasujiBuilderApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.displayGameEditorMenu();
	}

}
