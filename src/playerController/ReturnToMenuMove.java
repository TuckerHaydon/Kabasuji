package playerController;

import playerBoundary.KabasujiPlayerApplication;

public class ReturnToMenuMove implements IMove{
	KabasujiPlayerApplication app;
	
	public ReturnToMenuMove(KabasujiPlayerApplication app){
		this.app=app;
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
