package playerEntity;

import java.util.Hashtable;
import java.util.Stack;

import playerController.IMove;

public abstract class LevelAchievementMonitor {
	int moveCounter;
	boolean isillegalMove;
	Stack<String> popingUp;
	Hashtable<String, Achievement> achievements;
		
	public abstract boolean updateAchievement(IMove move);
	
	
	protected boolean notEarnBabyStep() {
		return !(achievements.get("SpeedyGonzales").getisEarned());
	}
	
	protected boolean notEarnRebel() {
		return !(achievements.get("Rebel").getisEarned());
	}
	 
	protected boolean notEarnOverAchiever() {
		return !(achievements.get("OverAchiever").getisEarned());
	}
	
	protected boolean notEarnSlowPoke() {
		return !(achievements.get("SlowPoke").getisEarned());
	}
	
	protected boolean notEarnSpeedyGonzales() {
		return !(achievements.get("SpeedyGonzales").getisEarned());
	}
	
	protected boolean notEarnJustUnderTheWire() {
		return !(achievements.get("JustUnderTheWire").getisEarned());
	}
	
	protected boolean notEarnNoRegrets() {
		return !(achievements.get("NoRegrets").getisEarned());
	}
	
	protected boolean notEarnRageQuit() {
		return !(achievements.get("RageQuit").getisEarned());
	}
	
	protected boolean checkBabySteps(IMove move){
		this.moveCounter++;
		if(this.moveCounter==10 && this.notEarnBabyStep()){
			achievements.get("BabySteps").setEarned();
			popingUp.add("BabyStep");
			return true;
		}
		return false;
	}
	
	protected boolean checkRebel(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
}
