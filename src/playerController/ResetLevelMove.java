package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author 
 *
 */
public class ResetLevelMove implements IMove{
	KabasujiPlayerApplication app;
	GameModel m;
	
	public ResetLevelMove(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
	}

	public boolean doMove(KabasujiPlayerApplication app) {
		System.out.println("Reset!");
		m.getCurrentLevel().reset();
		return true;
	}


	public boolean isValid(KabasujiPlayerApplication app) {
		return true;
	}

}
