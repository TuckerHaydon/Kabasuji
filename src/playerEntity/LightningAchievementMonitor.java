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
	
	@Override
	public boolean updateAchievement(IMove move, KabasujiPlayerApplication app) {
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkSlowPoke(IMove move, KabasujiPlayerApplication app){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(this.notEarnSlowPoke() && move.isValid(app) && lv.isTimeUsedUp() && typeMatched && !(lv.isLevelDone())){
			achievements.get("SlowPoke").setEarned();
			popingUp.push("SlowPoke");
			return true;
		}
		return false;
	}
	
	private boolean checkRageQuit(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		boolean somethingnew = false;
		return somethingnew;
	}
}
