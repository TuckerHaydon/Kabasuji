package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.LevelBuilderView;
import builderEntity.Board;
import builderEntity.BuilderModel;
import builderEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetLevelTypeMove extends Move {
	String levelType;
	String prev;
	
	SetLevelTypeMove(KabasujiBuilderApplication app, BuilderModel m, String levelType){
		super(app, m);
		this.levelType = levelType;
	}

	@Override
	boolean doMove() {
		prev = m.getLevel().getLevelType();
		m.setSelectedBoardEltType("playable");
		m.getLevel().setLevelType(levelType);
		m.getLevel().setBoard(new Board());
		app.getLevelEditor().refresh();
		app.getLevelEditor().getLevelBuilderView().changeViewLevelType(levelType);

		
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		m.getLevel().setLevelType(prev);
		app.getLevelEditor().getLevelBuilderView().changeViewLevelType(levelType);
		return true;
	}

	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
