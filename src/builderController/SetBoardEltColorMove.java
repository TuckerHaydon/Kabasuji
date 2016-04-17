package builderController;

import builderEntity.BuilderModel;

public class SetBoardEltColorMove implements IMove {

	BuilderModel model;
	String color;
	
	SetBoardEltColorMove(BuilderModel m, String color){
		this.model = m;
		this.color = color;
	}
	
	@Override
	public boolean doMove() {
		model.setSelectedColor(color);
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
