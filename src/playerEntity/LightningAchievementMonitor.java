package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * 
 * @author dorothy
 *
 */
public class LightningAchievementMonitor extends LevelAchievementMonitor{
	LightningLevel lv;
	
	public LightningAchievementMonitor(Hashtable<String,Achievement> achievements){
		super();
		this.achievements=achievements;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}
	
	@Override
	public void setLevel(Level lv) {
		reset();
		this.lv=(LightningLevel) lv;
	}
	
	@Override
	public boolean updateAchievement_whengotonextlevel(){
		if(this.checkSlowPoke()||this.checkVictoryLap()||this.checkSpeedyGonzales()){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateAchievement_releaseonbullpen(){
		return false;
	}
	@Override
	public boolean updateAchievement_wheninvalidmove(){
		if(this.checkRebel()){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateAchievement_releaseonboard(){
		this.moveCounter++;
		if(this.checkBabySteps()){
			return true;
		}
		return false;
	}
	@Override
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
	
	private boolean checkSpeedyGonzales(){
		if(this.notEarnSpeedyGonzales() && (lv.getUsedTime()<=(lv.getAllowedTime()*0.5)) && lv.hasWon()){
			achievements.get("SpeedyGonzales").setEarned();
			popingUp.push("SpeedyGonzales");
			return true;
		}
		return false;
	}

	@Override
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
		if(this.notEarnVictoryLap() && lv.hasWon() && lv.getIsCompleted()){
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
