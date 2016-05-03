package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * sets the boardElt type in the builder application
 * @author tuckerhaydon
 *
 */
public class SetBoardEltTypeMove extends Move{
	
	String boardEltType, prev;
	
	/**
	 * constructor for setBoardEltTypeMove
	 * @param app
	 * @param m
	 * @param bet
	 */
	SetBoardEltTypeMove(KabasujiBuilderApplication app, BuilderModel m, String bet){
		super(app, m);
		this.boardEltType = bet;
		
	}

	@Override
	boolean doMove() {
		
		prev = m.getSelectedBoardEltType();
		m.setSelectedBoardEltType(boardEltType);
		app.getLevelEditor().getLevelBuilderView().changeViewEltType(boardEltType);
		app.repaintLevelEditor();
		return true;
	}

	@Override
	public boolean undoMove() {
		
		m.setSelectedBoardEltType(prev);
		app.repaintLevelEditor();
		return true;
	}

	@Override
	boolean isValid() {
		return true;
	}

}
