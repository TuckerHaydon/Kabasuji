package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class NavigateLevelSelectionMenu implements ActionListener{
	
	KabasujiPlayerApplication app;
	
	public NavigateLevelSelectionMenu(KabasujiPlayerApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.displayLevelSelectionMenu();
	}

}
