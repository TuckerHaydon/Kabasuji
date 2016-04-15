package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;

public class ReleaseAchievementMonitor extends LevelAchievementMonitor{
	ReleaseLevel lv;
	
	public ReleaseAchievementMonitor(Hashtable<String,Achievement> achievements){
		this.achievements=achievements;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}
	
	public boolean updateAchievement_whengotonextlevel(){
		if(this.checkVictoryLap()||this.checkOverAchiever()){
			return true;
		}
		return false;
	}
	public boolean updateAchievement_whenclickbullpen(){
		this.moveCounter++;
		return false;
	}
	public boolean updateAchievement_wheninvalidmove(){
		if(this.checkRebel()){
			return true;
		}
		return false;
	}
	public boolean updateAchievement_whenclickboard(){
		this.moveCounter++;
		if(this.checkBabySteps()){
			return true;
		}
		return false;
	}
	public boolean updateAchievement_whenquit(){
		if(this.checkRageQuit()){
			return true;
		}
		return false;
	}
	
	/*Finished*/
	private boolean checkOverAchiever(){
		if(lv.hasWon() && lv.isCoverAll() && this.notEarnOverAchiever()){
			achievements.get("OverAchiever").setEarned();
			popingUp.push("OverAchiever");
			return true;
		}
		return false;
	}
	/*Finished*/
	boolean checkRageQuit(){
		if(this.notEarnRageQuit() && !(lv.hasWon())){
			achievements.get("RageQuit").setEarned();
			popingUp.push("RageQuit");
			return true;
		}
		return false;
	}

	/*Finished*/
	boolean checkVictoryLap() {
		if(lv.hasWon() && lv.getIsCompleted()){
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
