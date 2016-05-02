package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

public class SetNumAllowedMovesMove extends Move{
	int moves, prev;
	
	SetNumAllowedMovesMove(KabasujiBuilderApplication app, BuilderModel m, int moves){
		super(app, m);
		this.moves = moves;
	}

	@Override
	boolean doMove() {
		if(!isValid()) return false;
		prev = m.getLevel().getlevelData();
		m.getLevel().setLevelData(moves);
		return true;
	}

	@Override
	public boolean undoMove() {
		m.getLevel().setLevelData(prev);
		return true;
	}

	@Override
	boolean isValid() {
		return true;
	}
}
