package builderController;

import builderEntity.BuilderModel;

public class SetHintMove extends Move {
	
	boolean isHint;
	
	public SetHintMove(BuilderModel model, boolean isHint) {
		super(model);
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
