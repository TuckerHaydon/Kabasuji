package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;

public class PuzzleAchievementMonitor extends LevelAchievementMonitor{
	int toBullpenMove;
	PuzzleLevel lv;
	
	
	public PuzzleAchievementMonitor(PuzzleLevel lv, Hashtable<String, Achievement> achievements){
		this.lv=lv;
		this.achievements=achievements;
		this.isillegalMove=false;
		this.moveCounter=0;
		this.toBullpenMove=0;
		this.popingUp=new LinkedList<String>();
	}
	
	@Override
	public boolean updateAchievement(IMove move) {
		boolean somethingnew = false;
		return somethingnew;
	}
	
	/*Finished*/
	private boolean checkJustUnderTheWire(IMove move){
		if(lv.isMoveUsedUp() && lv.isLevelDone() && this.notEarnJustUnderTheWire()){
			achievements.get("JustUnderTheWire").setEarned();
			popingUp.push("JustUnderTheWire");
			return true;
		}
		return false;
	}
	
	private boolean checkNoRegrets(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	boolean checkRageQuit(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	
}
