package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;

public class LightningAchievementMonitor extends LevelAchievementMonitor{
	LightningLevel lv;
	
	public LightningAchievementMonitor(Hashtable<String,Achievement> achievements){
		this.achievements=achievements;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}
	
	/*Finished*/
	public void setLevel(Level lv) {
		reset();
		this.lv=(LightningLevel) lv;
	}
	
	public boolean updateAchievement_whengotonextlevel(){
		if(this.checkSlowPoke()||this.checkVictoryLap()){
			return true;
		}
		return false;
	}
	public boolean updateAchievement_whenclickbullpen(){
		if(this.checkBabySteps()){
			return true;
		}
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
	
	
	/*Finished*/ /*Have questions about isLevelDone */
	private boolean checkSlowPoke(){
		if(this.notEarnSlowPoke() && lv.isTimeUsedUp() && !(lv.hasWon())){
			achievements.get("SlowPoke").setEarned();
			popingUp.push("SlowPoke");
			return true;
		}
		return false;
	}
	/*Finished*/
	boolean checkRageQuit(){
		if(this.notEarnRageQuit() && !(lv.isTimeUsedUp()) && !(lv.hasWon())){
			achievements.get("RageQuit").setEarned();
			popingUp.push("RageQuit");
			return true;
		}
		return false;
	}

	@Override
	boolean checkVictoryLap() {
		if(lv.hasWon() && lv.getIsCompleted()){
			return true;
		}
		return false;
	}

	/*Finished*/
	public void reset() {
		this.lv=null;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}




}
