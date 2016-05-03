package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * This move in charge of setting hint elements
 * @author 
 *
 */
public class SetHintMove extends Move {
	
	boolean isHint;
	
	public SetHintMove(KabasujiBuilderApplication app, BuilderModel model, boolean isHint) {
		super(app, model);
		this.isHint = isHint;
	}
	
	@Override
	boolean doMove() {
		m.setHintSelected(isHint);
		return true;
	}

	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}

}
