package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Achievement monitor solely for lightning levels
 * Keeps track of Speedy Gonzales, Slowpoke, Baby Steps, Rage Quit
 * @author dorothy
 *
 */
public class LightningAchievementMonitor extends LevelAchievementMonitor{
	LightningLevel lv;
	
	/**
	 * Constructor for lightning achievement monitor
	 * @param achievements - all of the achievements possible
	 */
	public LightningAchievementMonitor(Hashtable<String,Achievement> achievements){
		super();
		this.achievements=achievements;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}
	
	/**
	 * set the level that the achievement monitor is in charge of
	 */
	@Override
	public void setLevel(Level lv) {
		reset();
		this.lv=(LightningLevel) lv;
	}
	
	/**
	 * Check to see if either SlowPoke or SpeedyGonzales has been reached upon level completion
	 */
	@Override
	public boolean updateAchievement_whencompletelevel(){
		if(this.checkSlowPoke()|this.checkSpeedyGonzales()){
			return true;
		}
		return false;
	}
	
	/**
	 * Check if anything has been released on bullpen (achievement: No Regrets)
	 */
	@Override
	public boolean updateAchievement_releaseonbullpen(){
		return false;
	}
	
	/**
	 * Check if any invalid moves have been made (achievement: Rebel)
	 */
	@Override
	public boolean updateAchievement_wheninvalidmove(){
		if(this.checkRebel()){
			return true;
		}
		return false;
	}
	
	/**
	 * Check if 10 tiles have been released on the board (achievement: BabySteps)
	 */
	@Override
	public boolean updateAchievement_releaseonboard(){
		this.moveCounter++;
		if(this.checkBabySteps()){
			return true;
		}
		return false;
	}
	
	/**
	 * Check to see if player quit in the middle of the game (achievement: RageQuit)
	 */
	@Override
	public boolean updateAchievement_whenquit(){
		if(this.checkRageQuit()){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * @return true if "SlowPoke" was just unlocked
	 */
	private boolean checkSlowPoke(){
		if(this.notEarnSlowPoke() && lv.isTimeUsedUp() && !(lv.getIsCompleted())){
			achievements.get("SlowPoke").setIsEarned(true);
			popingUp.push("SlowPoke");
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return true if "SpeedyGonzales" was just unlocked
	 */
	private boolean checkSpeedyGonzales(){
		if(this.notEarnSpeedyGonzales() && (lv.getUsedTime()<=(lv.getAllowedTime()*0.5)) && lv.getIsCompleted()){
			achievements.get("SpeedyGonzales").setIsEarned(true);
			popingUp.push("SpeedyGonzales");
			return true;
		}
		return false;
	}

	/**
	 * Check if Rage Quit has been accomplished
	 */
	@Override
	boolean checkRageQuit(){
		if(this.notEarnRageQuit() && !(lv.isTimeUsedUp()) && !(lv.getIsCompleted())){
			achievements.get("RageQuit").setIsEarned(true);
			popingUp.push("RageQuit");
			return true;
		}
		return false;
	}
	
	/**
	 * Reset level achievement data
	 */
	@Override
	public void reset() {
		this.lv=null;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}


}
