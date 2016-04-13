package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import builderEntity.Level;

public class CreateLevelHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	public CreateLevelHandler(KabasujiBuilderApplication app, BuilderModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.setLevel(new Level());
		app.displayLevelEditor();
		
	}

}
