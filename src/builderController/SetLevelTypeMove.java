package builderController;

import builderBoundary.LevelBuilderView;
import builderEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetLevelTypeMove implements IMove {
	Level l;
	String levelType;
	LevelBuilderView editorView;
	String prev;
	
	SetLevelTypeMove(Level l, String levelType, LevelBuilderView editorView){
		this.l = l;
		this.levelType = levelType;
		this.editorView = editorView;
	}

	@Override
	public boolean doMove() {
		prev = l.getLevelType();
		l.setLevelType(levelType);
		editorView.updateView(levelType);
		
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		l.setLevelType(prev);
		editorView.updateView(levelType);
		return true;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
