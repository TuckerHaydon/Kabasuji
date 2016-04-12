package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;
import playerController.ReturnToMenuMove;

public class LightningAchievementMonitor extends LevelAchievementMonitor{
	LightningLevel lv;
	
	public LightningAchievementMonitor(LightningLevel lv, Hashtable<String,Achievement> achievements){
		this.lv=lv;
		this.isillegalMove=false;
		this.achievements=achievements;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}
	
	/*Finished*/
	public boolean updateAchievement(IMove move) {
		return (checkSlowPoke(move) || checkRageQuit(move) || this.checkBabySteps(move) || this.checkRebel(move));
	}
	
	/*Finished*/ /*Have questions about isLevelDone */
	private boolean checkSlowPoke(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(this.notEarnSlowPoke() && lv.isTimeUsedUp() && typeMatched && !(lv.isLevelDone())){
			achievements.get("SlowPoke").setEarned();
			popingUp.push("SlowPoke");
			return true;
		}
		return false;
	}
	/*Finished*/
	private boolean checkRageQuit(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(this.notEarnRageQuit() && !(lv.isTimeUsedUp()) && typeMatched && !(lv.isLevelDone())){
			achievements.get("RageQuit").setEarned();
			popingUp.push("RageQuit");
			return true;
		}
		return false;
	}
}
