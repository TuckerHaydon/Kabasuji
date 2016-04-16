package builderController;

import builderEntity.BuilderModel;

public class SetBoardEltColorMove implements IMove {

	BuilderModel model;
	String color;
	
	SetBoardEltColorMove(BuilderModel m, String color){
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
