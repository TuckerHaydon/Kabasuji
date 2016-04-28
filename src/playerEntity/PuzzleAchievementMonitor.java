package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * 
 * @author dorothy
 *
 */
public class PuzzleAchievementMonitor extends LevelAchievementMonitor{
	int toBullpenMove;
	PuzzleLevel lv;
	
	
	public PuzzleAchievementMonitor(Hashtable<String, Achievement> achievements){
		super();
		this.achievements=achievements;
		this.moveCounter=0;
		this.toBullpenMove=0;
		this.popingUp=new LinkedList<String>();
	}
	
	@Override
	public void setLevel(Level lv) {
		reset();
		this.lv=(PuzzleLevel) lv;
	}
	@Override
	public boolean updateAchievement_whencompletelevel(){
		if(this.checkJustUnderTheWire()|this.checkNoRegrets()){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateAchievement_releaseonbullpen(){
		this.toBullpenMove++;
		return false;
	}
	//should goes to move class //
	@Override
	public boolean updateAchievement_wheninvalidmove(){
		if(this.checkRebel()){
			return true;
		}
		return false;
	}
	//should goes to board handler
	@Override
	public boolean updateAchievement_releaseonboard(){
		this.moveCounter++;
		if(this.checkBabySteps()){
			return true;
		}
		return false;
	}
	//should goes to Jbutton mainmenu handler
	@Override
	public boolean updateAchievement_whenquit(){
		if(this.checkRageQuit()){
			return true;
		}
		return false;
	}
	
	/*Finished*/
	private boolean checkJustUnderTheWire(){
		if(lv.isMoveUsedUp() && lv.getIsCompleted() && this.notEarnJustUnderTheWire()){
			achievements.get("JustUnderTheWire").setIsEarned(true);
			popingUp.push("JustUnderTheWire");
			return true;
		}
		return false;
	}
	
	/*Finished*/
	private boolean checkNoRegrets(){
		if(this.notEarnNoRegrets() && lv.getIsCompleted() && (this.toBullpenMove==0)){
			achievements.get("NoRegrets").setIsEarned(true);
			popingUp.push("NoRegrets");
			return true;
		}
		return false;
	}
	
	@Override
	boolean checkRageQuit(){
		if(this.notEarnRageQuit() && !(lv.getIsCompleted())){
			achievements.get("RageQuit").setIsEarned(true);
			popingUp.push("RageQuit");
			return true;
		}
		return false;
	}
	
	@Override
	public void reset() {
		this.lv=null;
		this.toBullpenMove=0;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}

}
