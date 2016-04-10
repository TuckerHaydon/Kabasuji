package playerEntity;

import java.util.Hashtable;

import playerController.IMove;

public abstract class LevelAchievementMonitor {
	int moveCounter;
	boolean isillegalMove;
	Hashtable<String, Achievement> achievements;
	
	public abstract boolean updateAchievement(IMove move);
	
	
	protected boolean earnBabyStep() {
		return achievements.get("SpeedyGonzales").getisEarned();
	}
	
	protected boolean earnRebel() {
		return achievements.get("Rebel").getisEarned();
	}
	 
	protected boolean earnOverAchiever() {
		return achievements.get("OverAchiever").getisEarned();
	}
	
	protected boolean earnSlowPoke() {
		return achievements.get("SlowPoke").getisEarned();
	}
	
	protected boolean earnSpeedyGonzales() {
		return achievements.get("SpeedyGonzales").getisEarned();
	}
	
	protected boolean earnJustUnderTheWire() {
		return achievements.get("JustUnderTheWire").getisEarned();
	}
	
	protected boolean earnNoRegrets() {
		return achievements.get("NoRegrets").getisEarned();
	}
	
	protected boolean earnRageQuit() {
		return achievements.get("RageQuit").getisEarned();
	}
	
	protected boolean checkBabySteps(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	protected boolean checkRebel(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
}
