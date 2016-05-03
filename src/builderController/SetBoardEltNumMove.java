package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * sets a boardElt number in the builder application 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltNumMove extends Move{
	
	int num;
	int prev;
	
	/**
	 * Constructor for setBoardEltNumMove
	 * @param app
	 * @param m
	 * @param num
	 */
	public SetBoardEltNumMove(KabasujiBuilderApplication app, BuilderModel m, int num) {
		super(app, m);
		this.num = num;
		this.m = m;
	}

	@Override
	boolean doMove() {
		
		prev = m.getSelectedNumber();
		m.setSelectedNumber(num);
		app.repaintLevelEditor();
		
		return true;
	}

	@Override
	public boolean undoMove() {
		m.setSelectedNumber(prev);
		return true;
	}

	@Override
	boolean isValid() {
		return true;
	}

}
