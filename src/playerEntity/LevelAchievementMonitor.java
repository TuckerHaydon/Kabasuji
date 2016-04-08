package playerEntity;

import java.util.Hashtable;

import playerController.IMove;

public abstract class LevelAchievementMonitor {
	int moveCounter;
	boolean isillegalMove;
	Hashtable<String, Achievement> achievements;
	
	public abstract boolean updateAchievement(IMove move);
	
	
	protected boolean earnBabyStep(IMove move) {
		return false;
	}
	
	protected boolean earnRebel(IMove move) {
		return false;
	}
	
	protected boolean earnOverAchiever(IMove move) {
		return false;
	}
	
	protected boolean earnSlowPoke(IMove move) {
		return false;
	}
	
	protected boolean earnSpeedyGonzales(IMove move) {
		return false;
	}
	
	protected boolean earnJustUnderTheWire(IMove move) {
		return false;
	}
	
	protected boolean earnNoRegrets(IMove move) {
		return false;
	}
	
	protected boolean earnRageQuit(IMove move) {
		return false;
	}
}
