package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import playerBoundary.KabasujiPlayerApplication;

public class TestLevelHandler implements ActionListener{

	BuilderModel m;
	
	public TestLevelHandler(BuilderModel m) {
		this.m = m;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		TestLevelMove move = new TestLevelMove(m);
		move.doMove();
	}

}
