package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * Controller class to add a level to a game in the builder application.
 * The class implements the ActionListener interface to process the action
 * upon invoking the actionPerformed method (in this case, the action is 
 * pressing a level button).
 * @see GameEditor
 * @see AddLevelToGameMove
 * @author tuckerhaydon
 *
 */
public class AddLevelToGameHandler implements ActionListener {
	
	BuilderModel m;
	int levelIndex;
	
	/**
	 * Default Constructor
	 * @param m the Builder Model
	 * @param levelIndex the index of the level being added
	 */
	public AddLevelToGameHandler(BuilderModel m, int levelIndex) {
		this.m = m;
		this.levelIndex = levelIndex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	/**
	 * Instantiate an AddLevelToGameMove and try to execute it
	 */
	void processAction(){
		AddLevelToGameMove move = new AddLevelToGameMove(m, levelIndex);
		move.execute();
	}

}
