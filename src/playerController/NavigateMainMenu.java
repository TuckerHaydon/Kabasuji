package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;

public class NavigateMainMenu implements ActionListener {
	
	KabasujiPlayerApplication app;
	
	public NavigateMainMenu(KabasujiPlayerApplication app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.displayMainMenu();
	}

}
