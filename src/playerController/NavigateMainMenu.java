package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class NavigateMainMenu implements ActionListener {
	KabasujiPlayerApplication app;
	GameModel m;
	
	public NavigateMainMenu(KabasujiPlayerApplication app, GameModel m) {
		this.app = app;
		this.m=m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		app.getGameWindow().releaseDraggedTile();
		app.displayMainMenu();
	}

}
