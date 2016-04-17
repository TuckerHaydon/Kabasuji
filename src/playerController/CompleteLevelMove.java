package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class CompleteLevelMove implements IMove{
	KabasujiPlayerApplication app;
	GameModel m;
	
	public CompleteLevelMove(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
	}
	
	public boolean doMove(KabasujiPlayerApplication app) {
		if(isValid(app)){
			if(m.getCurrentAM().updateAchievement_whengotonextlevel()){
				m.getCurrentAM().popUpScreen();
			}
			app.displayLevelSelectionMenu();
			return true;
		}
		return false;
	}


	public boolean isValid(KabasujiPlayerApplication app) {
		if(m.getCurrentLevel().hasWon()){
			return true;
		}
		return false;
	}
}
