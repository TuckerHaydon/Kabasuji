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
	
	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
