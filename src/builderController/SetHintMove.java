package builderController;

import builderEntity.BuilderModel;

public class SetHintMove implements IMove {
	
	boolean isHint;
	BuilderModel model;
	
	public SetHintMove(BuilderModel model, boolean isHint) {
		this.isHint = isHint;
		this.model = model;
	}
	
	@Override
	public boolean doMove() {
		model.setHintSelected(isHint);
		return true;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}

}
