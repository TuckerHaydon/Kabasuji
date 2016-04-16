package builderController;

import builderEntity.BuilderModel;

public class SetBoardEltNumMove implements IMove{
	
	int num;
	BuilderModel m;
	
	public SetBoardEltNumMove(BuilderModel m, int num) {
		this.num = num;
		this.m = m;
	}

	@Override
	public boolean doMove() {
		m.setSelectedNumber(num);
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
		return false;
	}

}
