package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;
import playerController.ReturnToMenuMove;

public class ReleaseAchievementMonitor extends LevelAchievementMonitor{
	ReleaseLevel lv;
	
	public ReleaseAchievementMonitor(Hashtable<String,Achievement> achievements){
		this.achievements=achievements;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}
	
	/*Finished*/
	public boolean updateAchievement(IMove move) {
		if(checkOverAchiever(move) && checkRageQuit(move) && this.checkVictoryLap(move)
				&& this.checkBabySteps(move) && this.checkRebel(move)){
			return true;
		}
		return false;		
	}
	
	/*Finished*/
	private boolean checkOverAchiever(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(typeMatched && lv.hasWon() && lv.isCoverAll() && this.notEarnOverAchiever()){
			achievements.get("OverAchiever").setEarned();
			popingUp.push("OverAchiever");
			return true;
		}
		return false;
	}
	/*Finished*/
	boolean checkRageQuit(IMove move){
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(this.notEarnRageQuit() && typeMatched && !(lv.hasWon())){
			achievements.get("RageQuit").setEarned();
			popingUp.push("RageQuit");
			return true;
		}
		return false;
	}

	@Override
	boolean checkVictoryLap(IMove move) {
		boolean typeMatched = move instanceof ReturnToMenuMove;
		if(typeMatched && lv.hasWon() && lv.getIsCompleted()){
			achievements.get("VictoryLap").setEarned();
			popingUp.push("VictoryLap");
			return true;
		}
		return false;
	}

	/*Finished*/
	public void setLevel(Level lv) {
		reset();
		this.lv=(ReleaseLevel) lv;
	}

	/*Finish*/
	protected void reset() {
		this.lv=null;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();	
	}
}
