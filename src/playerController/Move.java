package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
abstract class Move {
	
	KabasujiPlayerApplication app;
	GameModel m;
	
	public Move(KabasujiPlayerApplication app, GameModel m){
		this.app = app;
		this.m = m;
	}
	
	public boolean execute(){
		
		if(!this.isValid()){
			return false;
		}
		
		return this.doMove();
	}
	
	abstract boolean doMove();
	abstract boolean isValid();
	public abstract boolean undo();
}
