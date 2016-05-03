package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * sets the numAllowedMoves for the puzzle level in the builder application
 * @author dgwalder
 *
 */
public class SetNumAllowedMovesMove extends Move{
	int moves, prev;
	
	/**
	 * constructor for setNumAllowedMovesMove
	 * @param app
	 * @param m
	 * @param moves
	 */
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
