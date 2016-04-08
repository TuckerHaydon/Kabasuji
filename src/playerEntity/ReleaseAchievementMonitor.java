package playerEntity;

import java.util.Hashtable;

import playerController.IMove;

public class ReleaseAchievementMonitor extends LevelAchievementMonitor{
	int numberCovered;
	ReleaseLevel lv;
	
	
	public ReleaseAchievementMonitor(ReleaseLevel lv, Hashtable<String,Achievement> achievements){
		this.lv=lv;
		this.achievements=achievements;
		this.moveCounter=0;
		this.numberCovered=0;
		this.isillegalMove=false;
	}
	
	@Override
	public boolean updateAchievement(IMove move) {
		boolean somethingnew = false;
		return somethingnew;		
	}
}
