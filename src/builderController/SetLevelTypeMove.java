package builderController;

import builderEntity.Level;

public class SetLevelTypeMove implements IMove {
	Level l;
	String levelType;
	
	SetLevelTypeMove(Level l, String levelType){
		this.l = l;
		this.levelType = levelType;
		
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
