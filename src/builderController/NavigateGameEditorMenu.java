package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

/**
 * navigates to the game editor menu
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
