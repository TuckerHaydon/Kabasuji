package builderController;

import builderEntity.BuilderModel;
import builderEntity.Level;

public class SetNumAllowedMovesMove extends Move{
	BuilderModel model;
	int moves, prev;
	
	SetNumAllowedMovesMove(BuilderModel m, int moves){
		super(m);
		this.model = m;
		this.moves = moves;
	}

	@Override
	boolean doMove() {
		prev = model.getLevel().getlevelData();
		model.getLevel().setLevelData(moves);
		return true;
	}

	@Override
	public boolean undoMove() {
		model.getLevel().setLevelData(prev);
		return true;
	}

	@Override
	boolean isValid() {
		boolean valid = false;
		if(model.getLevel().getLevelType() == Level.PUZZLE) {
			valid = true;
		}
		return valid;
	}
}
