package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderEntity.BuilderModel;

public class AddLevelToGameHandler implements ActionListener {
	
	int levelIndex;
	BuilderModel m;
	
	public AddLevelToGameHandler(BuilderModel m, int levelIndex) {
		this.m = m;
		this.levelIndex = levelIndex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AddLevelToGameMove move = new AddLevelToGameMove(m, levelIndex);
		
		if(move.isValid()){
			move.doMove();
		}
		
	}

}
