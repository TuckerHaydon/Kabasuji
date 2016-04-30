package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;
/**
 * Achievement monitor solely for release levels
 * Keeps track of Victory Lap, OverAchiever, Rebel, BabySteps, RageQuit
 * @author dorothy
 *
 */
public class ReleaseAchievementMonitor extends LevelAchievementMonitor{
	ReleaseLevel lv;
	
	/**
	 * Constructor for release achievement monitor
	 * @param achievements - all of the achievements possible
	 */
	public ReleaseAchievementMonitor(Hashtable<String,Achievement> achievements){
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
		this.lv=(ReleaseLevel) lv;
	}
	
	/**
	 * Check to see if either VictoryLap or OverAchiever has been reached upon level completion
	 */
	@Override
	public boolean updateAchievement_whencompletelevel(){
		if(this.checkOverAchiever()|this.checkOverAchiever()){
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
	 * Check to see if the player has fulfilled the OverAchiever (win 3 levels in a row) achievement
	 */
	private boolean checkOverAchiever(){
		if(this.notEarnOverAchiever() && lv.getIsCompleted() && lv.isCoverAll()){
			achievements.get("OverAchiever").setIsEarned(true);
			popingUp.push("OverAchiever");
			return true;
		}
		return false;
	}
	
	/**
	 * Check to see if the player has quit in the middle of a level (RageQuit)
	 */
	@Override
	boolean checkRageQuit(){
		if(this.notEarnRageQuit() && !(lv.getIsCompleted())){
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
