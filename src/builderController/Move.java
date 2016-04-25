/**
 * 
 */
package builderController;

import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public abstract class Move {
	
	BuilderModel m;
	
	public Move(BuilderModel m){
		this.m = m;
	}

	public boolean execute(){
		
		if(!this.isValid()){
			return false;
		}
		
		if(this.doMove()){
			UndoManager.pushMove(this);
			RedoManager.clear();
			return true;
		}
		
		return false;
	}
	
	abstract boolean doMove();
	abstract boolean isValid();
	public abstract boolean undoMove();
}
