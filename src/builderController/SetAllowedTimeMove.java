package builderController;

import builderEntity.BuilderModel;

public class SetAllowedTimeMove implements IMove {
	BuilderModel model;
	
	SetAllowedTimeMove(BuilderModel m){
		this.model = m;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
}
