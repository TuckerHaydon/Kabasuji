package playerEntity;

import java.util.Hashtable;

import playerController.IMove;

public class LightningAchievementMonitor extends LevelAchievementMonitor{
	boolean slowpoke;
	boolean speedyGonzale;
	LightningLevel lv;
	
	public LightningAchievementMonitor(LightningLevel lv, Hashtable<String,Achievement> achievements){
		this.lv=lv;
		this.isillegalMove=false;
		this.achievements=achievements;
		this.moveCounter=0;
		this.slowpoke=false;
		this.speedyGonzale=false;
	}
	
	@Override
	public boolean updateAchievement(IMove move) {
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkSlowPoke(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkRageQuit(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
}
