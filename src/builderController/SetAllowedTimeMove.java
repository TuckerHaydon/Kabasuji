package builderController;

import builderEntity.BuilderModel;
import builderEntity.Level;

public class SetAllowedTimeMove implements IMove {
	BuilderModel model;
	int minutes;
	int seconds;
	int prevSec;
	
	SetAllowedTimeMove(BuilderModel m, int min, int sec){
		this.model = m;
		this.minutes = min;
		this.seconds = sec;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		if(isValid()){
			prevSec = model.getLevel().getlevelData();
			model.getLevel().setLevelData((minutes * 60) + seconds);
		}
		else return false;
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		if(isValid()) model.getLevel().setLevelData(prevSec);
		else return false;
		return true;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		if(((minutes * 60) + seconds) >=  0 && (model.getLevel().getLevelType() == Level.LIGHTNING)) return true;
		return false;
	}
}
