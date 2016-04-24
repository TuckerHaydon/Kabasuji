package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import playerBoundary.KabasujiPlayerApplication;

public class TestLevelHandler implements ActionListener{
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	public TestLevelHandler(KabasujiBuilderApplication app, BuilderModel m) {
		this.app=app;
		this.m = m;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		TestLevelMove move = new TestLevelMove(app, m);
		move.doMove();
	}

}
