package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * Abstract class for all moves in the Kabasuji player application
 * @author tuckerhaydon
 *
 * @see PickUpTileBoardMove
 * @see PickUpTileBullpenMove
 * @see CompleteLevelMove
 * @see MirrorTileHorizontalMove
 * @see MirrorTileVerticalMove
 * @see PrematureCompleteLevelMove
 * @see ResetAchievementMove
 * @see ResetLevelMove
 * @see RotateTileCounterClockwiseMove
 * @see RotateTileClockwiseMove
 * @see TileToBoardMove
 * @see TileToBullpenMove
 * @see UpdateDraggedTileLocationMove
 */
public abstract class Move {
	
	KabasujiPlayerApplication app;
	GameModel m;
	
	/**
	 * Constructor for Move
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 */
	public Move(KabasujiPlayerApplication app, GameModel m){
		this.app = app;
		this.m = m;
	}
	
	/**
	 * Do the move, pushed to undo/redo
	 * @return
	 */
	public boolean execute(){
		
		if(!this.isValid()){
			return false;
		}
		UndoManager.pushMove(this);
		RedoManager.clear();
		
		return this.doMove();
	}
	
	/**
	 * Handles undo/redo
	 * @return
	 */
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
	
	public boolean redoMove(){
		boolean wasSuccessful = this.doMove();

		if(wasSuccessful){
			UndoManager.pushMove(this);
		}
		
		app.repaintAll();
		
		return wasSuccessful;
	}
}
