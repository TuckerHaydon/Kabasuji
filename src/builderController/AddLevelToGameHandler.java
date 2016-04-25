package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class AddLevelToGameHandler implements ActionListener {
	
	BuilderModel m;
	int levelIndex;
	
	
	public AddLevelToGameHandler(BuilderModel m, int levelIndex) {
		this.m = m;
		this.levelIndex = levelIndex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		
		AddLevelToGameMove move = new AddLevelToGameMove(m, levelIndex);
		move.execute();
	}

}
