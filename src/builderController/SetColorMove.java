package builderController;

import builderEntity.BuilderModel;

public class SetColorMove implements IMove {

	BuilderModel model;
	
	SetColorMove(BuilderModel m){
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
