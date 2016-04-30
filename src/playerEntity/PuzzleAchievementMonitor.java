package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Achievement monitor solely for puzzle levels
 * Keeps track of Just Under the Wire, Rebel, Baby Steps, Rage Quit, No Regrets
 * @author dorothy
 *
 */
public class PuzzleAchievementMonitor extends LevelAchievementMonitor{
	int toBullpenMove;
	PuzzleLevel lv;
	
	/**
	 * Constructor for puzzle level achievement monitor
	 * @param achievements - all of the achievements possible
	 */
	public PuzzleAchievementMonitor(Hashtable<String, Achievement> achievements){
		super();
		this.achievements=achievements;
		this.moveCounter=0;
		this.toBullpenMove=0;
		this.popingUp=new LinkedList<String>();
	}
	
	/**
	 * set the level that the achievement monitor is in charge of
	 */
	@Override
	public void setLevel(Level lv) {
		reset();
		this.lv=(PuzzleLevel) lv;
	}
	
	/**
	 * Check to see if either JustUnderTheWire or NoRegrets has been reached upon level completion
	 */
	@Override
	public boolean updateAchievement_whencompletelevel(){
		if(this.checkJustUnderTheWire()|this.checkNoRegrets()){
			return true;
		}
		return false;
	}
	
	/**
	 * Check if anything has been released on bullpen (achievement: No Regrets)
	 */
	@Override
	public boolean updateAchievement_releaseonbullpen(){
		this.toBullpenMove++;
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
	 * When the game is finished, check to see if JustUnderTheWire has been reached
	 */
	private boolean checkJustUnderTheWire(){
		if(lv.isMoveUsedUp() && lv.getIsCompleted() && this.notEarnJustUnderTheWire()){
			achievements.get("JustUnderTheWire").setIsEarned(true);
			popingUp.push("JustUnderTheWire");
			return true;
		}
		return false;
	}
	
	/**
	 * When the game is finished, check to see if No Regrets (never having returned anything to the bullpen) has been reached
	 */
	private boolean checkNoRegrets(){
		if(this.notEarnNoRegrets() && lv.getIsCompleted() && (this.toBullpenMove==0)){
			achievements.get("NoRegrets").setIsEarned(true);
			popingUp.push("NoRegrets");
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
		this.toBullpenMove=0;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}

}
