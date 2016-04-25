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
 */
public class AddLevelToGameHandler implements ActionListener {
	
	BuilderModel m;
	int levelIndex;
	
	/**
<<<<<<< HEAD
	 * Default Constructor
	 * @param m the Builder Model
	 * @param levelIndex the index of the level being added
=======
	 * Constructor. Validates that the parameters are non-null and that levelIndex is contained within [0,14]
	 * @param m  The top-level builder model
	 * @param levelIndex The index where the level is to be added
>>>>>>> branch 'master' of https://github.com/TuckerHaydon/Kabasuji-Cebriones
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
	
	/**
	 * Instantiate an AddLevelToGameMove and try to execute it
	 */
	void processAction(){
		AddLevelToGameMove move = new AddLevelToGameMove(m, levelIndex);
		move.execute();
	}

}
