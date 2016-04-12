package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;
import playerController.ReturnToMenuMove;

public class ReleaseAchievementMonitor extends LevelAchievementMonitor{
	ReleaseLevel lv;
	
	
	public ReleaseAchievementMonitor(ReleaseLevel lv, Hashtable<String,Achievement> achievements){
		this.lv=lv;
		this.achievements=achievements;
		this.moveCounter=0;
		this.isillegalMove=false;
		this.popingUp=new LinkedList<String>();
	}
	
	/*Finished*/
	public boolean updateAchievement(IMove move) {
		if(checkOverAchiever(move) && checkRageQuit(move) && this.checkBabySteps(move) && this.checkRebel(move)){
			return true;
		}
		return false;		
	}
	
	/*Finished*/
	private boolean checkOverAchiever(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(typeMatched && lv.isLevelDone() && lv.isCoverAll() && this.notEarnOverAchiever()){
			achievements.get("OverAchiever").setEarned();
			popingUp.push("OverAchiever");
			return true;
		}
		return false;
	}
	/*Finished*/
	boolean checkRageQuit(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(this.notEarnRageQuit() && typeMatched && !(lv.isLevelDone())){
			achievements.get("RageQuit").setEarned();
			popingUp.push("RageQuit");
			return true;
		}
		return false;
	}
}
