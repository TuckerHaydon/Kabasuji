package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * The move setting the number on the board element
 * @author tuckerhaydon
 *
 */
public class SetBoardEltNumMove extends Move{
	
	int num;
	int prev;
	
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
		// TODO Auto-generated method stub
		return true;
	}

}
