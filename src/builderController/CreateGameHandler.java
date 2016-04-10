package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import builderEntity.Game;

public class CreateGameHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	public CreateGameHandler(KabasujiBuilderApplication app, BuilderModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.setGame(new Game());
		app.displayGameEditor();
		
	}

}
