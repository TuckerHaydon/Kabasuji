package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * The move of setting allowed time in level editor
 * @author Dorothy
 *
 */
public class SetAllowedTimeMove extends Move {
	
	int seconds;
	int prevSec;
	
	public SetAllowedTimeMove(KabasujiBuilderApplication app, BuilderModel m, int sec){
		super(app, m);
		this.seconds = sec;
	}

	@Override
	boolean doMove() {
		prevSec = m.getLevel().getlevelData();
		m.getLevel().setLevelData(seconds);
		return true;
	}

	@Override
	public boolean undoMove() {
		if(isValid()) m.getLevel().setLevelData(prevSec);
		else return false;
		return true;
	}

	@Override
	boolean isValid() {
		if(seconds >=  0) {
			return true;
		}
		return false;
	}
}
