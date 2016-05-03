package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * sets the allowed time for the lightning level in the builder application
 */
public class SetAllowedTimeMove extends Move {
	
	int seconds;
	int prevSec;
	
	/**
	 * constructor for setAllowedTimeMove
	 * @param app
	 * @param m
	 * @param sec
	 */
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
