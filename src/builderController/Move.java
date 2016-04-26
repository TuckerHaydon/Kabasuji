/**
 * 
 */
package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public abstract class Move {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	public Move(KabasujiBuilderApplication app, BuilderModel m){
		this.app = app;
		this.m = m;
	}

	public boolean execute(){
		
		if(!this.isValid()){
			return false;
		}
		
		if(this.doMove()){
			UndoManager.pushMove(this);
			RedoManager.clear();
			app.repaintLevelEditor();
			return true;
		}
		
		return false;
	}
	
	public boolean executeUndo(){
		boolean wasSuccessful = this.undoMove();
		app.refreshLevelEditor();
		
		return wasSuccessful;
	}
	
	abstract boolean doMove();
	abstract boolean isValid();
	abstract boolean undoMove();
}
