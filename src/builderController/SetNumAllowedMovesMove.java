package builderController;

import builderEntity.BuilderModel;
import builderEntity.Level;

public class SetNumAllowedMovesMove implements IMove{
	BuilderModel model;
	int moves, prev;
	
	SetNumAllowedMovesMove(BuilderModel m, int moves){
		this.model = m;
		this.moves = moves;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(isValid()){
			prev = model.getLevel().getlevelData();
			model.getLevel().setLevelData(moves);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		model.getLevel().setLevelData(prev);
		return true;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		boolean valid = false;
		if(model.getLevel().getLevelType() == Level.PUZZLE) {
			valid = true;
		}
		return valid;
	}
}
