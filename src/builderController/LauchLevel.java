package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import builderBoundary.KabasujiBuilderApplication;
import playerBoundary.KabasujiPlayerApplication;

public class LauchLevel implements ActionListener{
	KabasujiBuilderApplication app;
	
	public LauchLevel(KabasujiBuilderApplication app) {
		this.app=app;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		KabasujiPlayerApplication playerapp = new KabasujiPlayerApplication("src/resources/games/Tuckers_Game");
		app.hideAll();
	}

}
