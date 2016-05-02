package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

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
		m.setHintSelected(false);
		m.getLevel().setLevelType(levelType);
		if(prev.equals("release") && !levelType.equals("release")) m.getLevel().getBoard().resetAfterRelease();
		app.getLevelEditor().refresh();
		app.getLevelEditor().getLevelBuilderView().getBoardView().repaint();
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
