package builderController;

import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltNumMove implements IMove{
	
	int num;
	BuilderModel m;
	int prev;
	
	public SetBoardEltNumMove(BuilderModel m, int num) {
		this.num = num;
		this.m = m;
	}

	@Override
	public boolean doMove() {
		if(isValid()){
			prev = m.getSelectedNumber();
			m.setSelectedNumber(num);
		} else return false;
		
		return true;
	}

	@Override
	public boolean undoMove() {
		m.setSelectedNumber(prev);
		return true;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
