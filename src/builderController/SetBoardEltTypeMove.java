package builderController;

import builderEntity.BuilderModel;

public class SetBoardEltTypeMove implements IMove{
	
	BuilderModel model;
	String boardEltType;
	
	SetBoardEltTypeMove(BuilderModel m, String bet){
		this.model = m;
		this.boardEltType = bet;
		
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
