package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public abstract class Move {
	
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
		RedoManager.clear();
		
		return this.doMove();
	}
	
	public boolean executeUndo(){
		boolean wasSuccessful = this.undo();
		
		if(wasSuccessful){
			RedoManager.pushMove(this);
		}
		
		app.repaintAll();		
		return wasSuccessful;
	}
	
	abstract boolean doMove();
	abstract boolean isValid();
	abstract boolean undo();
}
