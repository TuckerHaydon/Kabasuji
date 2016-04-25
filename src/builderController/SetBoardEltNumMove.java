package builderController;

import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltNumMove extends Move{
	
	int num;
	int prev;
	
	public SetBoardEltNumMove(BuilderModel m, int num) {
		super(m);
		this.num = num;
		this.m = m;
	}

	@Override
	boolean doMove() {
		
		prev = m.getSelectedNumber();
		m.setSelectedNumber(num);
		
		return true;
	}

	@Override
	public boolean undoMove() {
		m.setSelectedNumber(prev);
		return true;
	}

	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
