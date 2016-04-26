package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import playerBoundary.KabasujiPlayerApplication;

public class TestLevelHandler implements ActionListener{

	BuilderModel m;
	KabasujiBuilderApplication app;
	
	public TestLevelHandler(KabasujiBuilderApplication app, BuilderModel m) {
		this.m = m;
		this.app = app;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		TestLevelMove move = new TestLevelMove(app, m);
		move.execute();
	}

}
