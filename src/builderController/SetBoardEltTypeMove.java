package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltTypeMove extends Move{
	
	KabasujiBuilderApplication app;
	String boardEltType, prev;
	
	SetBoardEltTypeMove(KabasujiBuilderApplication app, BuilderModel m, String bet){
		super(m);
		this.app = app;
		this.boardEltType = bet;
		
	}

	@Override
	boolean doMove() {
		
		prev = m.getSelectedBoardEltType();
		m.setSelectedBoardEltType(boardEltType);
		app.refreshLevelEditor();
		return true;
	}

	@Override
	public boolean undoMove() {
		
		m.setSelectedBoardEltType(prev);
		app.refreshLevelEditor();
		return true;
	}

	@Override
	boolean isValid() {
		return true;
	}

}
