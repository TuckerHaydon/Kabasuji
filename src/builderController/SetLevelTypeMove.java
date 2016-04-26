package builderController;

import builderBoundary.KabasujiBuilderApplication;
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
	
	SetLevelTypeMove(KabasujiBuilderApplication app, BuilderModel m, Level l, String levelType, LevelBuilderView editorView){
		super(app, m);
		this.l = l;
		this.levelType = levelType;
		this.editorView = editorView;
	}

	@Override
	boolean doMove() {
		prev = l.getLevelType();
		m.setSelectedBoardEltType("playable");
		l.setLevelType(levelType);
		editorView.changeViewLevelType(levelType);
		
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		l.setLevelType(prev);
		editorView.changeViewLevelType(levelType);
		return true;
	}

	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
