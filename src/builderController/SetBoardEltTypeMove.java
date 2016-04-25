package builderController;

import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltTypeMove extends Move{
	
	String boardEltType, prev;
	
	SetBoardEltTypeMove(BuilderModel m, String bet){
		super(m);
		this.boardEltType = bet;
		
	}

	@Override
	boolean doMove() {
		
		prev = m.getSelectedBoardEltType();
		m.setSelectedBoardEltType(boardEltType);
		return true;
	}

	@Override
	public boolean undoMove() {
		
		m.setSelectedBoardEltType(prev);
		return false;
	}

	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
