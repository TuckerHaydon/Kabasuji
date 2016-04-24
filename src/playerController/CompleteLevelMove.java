package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author 
 *
 */
public class CompleteLevelMove implements IMove{
	GameModel m;
	
	public CompleteLevelMove(GameModel m){
		this.m=m;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		
		// Validate the move
		if(!this.isValid(app)){
			return false;
		}
		
		if(m.getCurrentAM().updateAchievement_whengotonextlevel()){
			m.getCurrentAM().popUpScreen();
		}
		
		app.displayLevelSelectionMenu();
		app.getGameWindow().updateView();
		return true;

	}

	/*Finished*/
	public boolean isValid(KabasujiPlayerApplication app) {
		if(m.getCurrentLevel().hasWon()){
			return true;
		}
		return false;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		return false;
	}
}
