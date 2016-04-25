package builderController;

import builderEntity.BuilderModel;
import builderEntity.Level;

public class SetAllowedTimeMove extends Move {
	
	int minutes;
	int seconds;
	int prevSec;
	
	SetAllowedTimeMove(BuilderModel m, int min, int sec){
		super(m);
		this.minutes = min;
		this.seconds = sec;
	}

	@Override
	boolean doMove() {
		prevSec = m.getLevel().getlevelData();
		m.getLevel().setLevelData((minutes * 60) + seconds);
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
		if(((minutes * 60) + seconds) >=  0 && (m.getLevel().getLevelType() == Level.LIGHTNING)) return true;
		return false;
	}
}
