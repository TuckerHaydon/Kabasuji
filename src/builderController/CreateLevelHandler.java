package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import builderEntity.Level;

/**
 * CreateLevelHandler class
 * handles the creation of a level in the builder application
 * @author tuckerhaydon
 *
 */
public class CreateLevelHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	/**
	 * CreateLevelHandlerConstructor
	 * @param app
	 * @param m
	 */
	public CreateLevelHandler(KabasujiBuilderApplication app, BuilderModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		m.setLevel(new Level());
		app.refreshLevelEditor();
		app.displayLevelEditor();	
	}

}
