package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author 
 *
 */
public class CompleteLevelMove extends Move{
	
	public CompleteLevelMove(KabasujiPlayerApplication app, GameModel m){
		super(app, m);
	}
	
	@Override
	public boolean doMove() {
		
		if(m.getCurrentAM().updateAchievement_whengotonextlevel()){
			m.getCurrentAM().popUpScreen();
		}
		
		app.displayLevelSelectionMenu();
		app.getGameWindow().updateView();
		return true;
	}

	@Override
	boolean isValid() {
		if(m.getCurrentLevel().hasWon()){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean undo() {
		return false;
	}
}
