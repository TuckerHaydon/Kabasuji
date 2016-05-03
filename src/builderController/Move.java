/**
 * 
 */
package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * Abstract class for all moves in the Kabasuji builder application
 * @author tuckerhaydon
 *
 */
public abstract class Move {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	/**
	 * Constructor for move
	 * @param app
	 * @param m
	 */
	public Move(KabasujiBuilderApplication app, BuilderModel m){
		this.app = app;
		this.m = m;
	}

	/**
	 * do the move, pushed to undo/redo
	 * @return
	 */
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
	
	/**
	 * Handles undo/redo
	 * @return
	 */
	public boolean executeUndo(){
		boolean wasSuccessful = this.undoMove();

		if(wasSuccessful){
			RedoManager.pushMove(this);
		}
		
		app.repaintLevelEditor();
		
		return wasSuccessful;
	}
	
	abstract boolean doMove();
	abstract boolean isValid();
	abstract boolean undoMove();
	
	public boolean redoMove(){
		boolean wasSuccessful = this.doMove();

		if(wasSuccessful){
			UndoManager.pushMove(this);
		}
		
		app.repaintLevelEditor();
		
		return wasSuccessful;
	}
}
