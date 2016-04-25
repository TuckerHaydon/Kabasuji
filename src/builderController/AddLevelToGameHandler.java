package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * Handler to add a level to the builder model game. 
 * @author tuckerhaydon
 */
public class AddLevelToGameHandler implements ActionListener {
	
	BuilderModel m;
	int levelIndex;
	
	/**
	 * Constructor. Validates that the parameters are non-null and that levelIndex is contained within [0,14]
	 * @param m  The top-level builder model
	 * @param levelIndex The index where the level is to be added
	 */
	public AddLevelToGameHandler(BuilderModel m, int levelIndex) {
		
		if(m == null || (levelIndex < 0 || levelIndex > 14)){
			throw new RuntimeException();
		}
		
		this.m = m;
		this.levelIndex = levelIndex;
	}

	/**
	 * Creates and executes a move to add the level to the game
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	void processAction(){
		
		AddLevelToGameMove move = new AddLevelToGameMove(m, levelIndex);
		move.execute();
	}

}
