package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;
import playerController.ReturnToMenuMove;
import playerController.TileToBullpenMove;

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
	
	/*Finished*/
	public boolean updateAchievement(IMove move) {
		if(move instanceof TileToBullpenMove){
			this.toBullpenMove++;
		}
		if(this.checkJustUnderTheWire(move) && this.checkNoRegrets(move) 
				&& this.checkRageQuit(move) && this.checkBabySteps(move) && this.checkRebel(move)){
			return true;
		}
		return false;
	}
	
	/*Finished*/
	private boolean checkJustUnderTheWire(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(typeMatched && lv.isMoveUsedUp() && lv.isLevelDone() && this.notEarnJustUnderTheWire()){
			achievements.get("JustUnderTheWire").setEarned();
			popingUp.push("JustUnderTheWire");
			return true;
		}
		return false;
	}
	/*Finished*/
	private boolean checkNoRegrets(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(typeMatched && lv.isLevelDone() && (this.toBullpenMove==0) && this.notEarnNoRegrets()){
			achievements.get("NoRegrets ").setEarned();
			popingUp.push("NoRegrets");
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
