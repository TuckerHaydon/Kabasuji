package builderController;

import builderBoundary.LevelBuilderView;
import builderEntity.BuilderModel;
import builderEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetLevelTypeMove extends Move {
	Level l;
	String levelType;
	LevelBuilderView editorView;
	String prev;
	
	SetLevelTypeMove(BuilderModel m, Level l, String levelType, LevelBuilderView editorView){
		super(m);
		this.l = l;
		this.levelType = levelType;
		this.editorView = editorView;
	}

	@Override
	boolean doMove() {
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
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
