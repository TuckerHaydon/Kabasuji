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
		UndoManager.pushMove(this);
		return this.doMove();
	}
	
	public boolean executeUndo(){
//		boolean wasSuccessful = this.undoMove();
//		app.refreshLevelEditor();
		
//		return wasSuccessful;
		return true;
	}
	
	abstract boolean doMove();
	abstract boolean isValid();
	abstract boolean undo();
}
