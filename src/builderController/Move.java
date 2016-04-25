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
	
	BuilderModel m;
	
	public Move(BuilderModel m){
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
	public abstract boolean undoMove();
}
