package builderController;

import builderBoundary.LevelBuilderView;
import builderEntity.Level;

public class SetLevelTypeMove implements IMove {
	Level l;
	String levelType;
	LevelBuilderView editorView;
	
	SetLevelTypeMove(Level l, String levelType, LevelBuilderView editorView){
		this.l = l;
		this.levelType = levelType;
		this.editorView = editorView;
	}

	@Override
	public boolean doMove() {
		
		l.setLevelType(levelType);
		editorView.updateView(levelType);
		
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
