package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class NavigateGameEditorMenu implements ActionListener {
	
	KabasujiBuilderApplication app;
	
	public NavigateGameEditorMenu(KabasujiBuilderApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.displayGameEditorMenu();
	}

}
