package builderController;

import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltTypeMove implements IMove{
	
	BuilderModel model;
	String boardEltType, prev;
	
	SetBoardEltTypeMove(BuilderModel m, String bet){
		this.model = m;
		this.boardEltType = bet;
		
	}

	@Override
	public boolean doMove() {
		
		prev = model.getSelectedBoardEltType();
		model.setSelectedBoardEltType(boardEltType);
		return true;
	}

	@Override
	public boolean undoMove() {
		
		model.setSelectedBoardEltType(prev);
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
