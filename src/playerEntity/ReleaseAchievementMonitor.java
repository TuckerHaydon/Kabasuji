package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;
/**
 * 
 * @author dorothy
 *
 */
public class ReleaseAchievementMonitor extends LevelAchievementMonitor{
	ReleaseLevel lv;
	
	public ReleaseAchievementMonitor(Hashtable<String,Achievement> achievements){
		super();
		this.achievements=achievements;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}
	@Override
	public void setLevel(Level lv) {
		reset();
		this.lv=(ReleaseLevel) lv;
	}
	
	@Override
	public boolean updateAchievement_whengotonextlevel(){
		if(this.checkVictoryLap()||this.checkOverAchiever()||this.checkOverAchiever()){
			return true;
		}
		return false;
	}
	@Override
	public boolean updateAchievement_releaseonbullpen(){
		this.moveCounter++;
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
	
	/*Finished*/
	private boolean checkOverAchiever(){
		if(lv.hasWon() && lv.isCoverAll() && this.notEarnOverAchiever()){
			achievements.get("OverAchiever").setIsEarned(true);
			popingUp.push("OverAchiever");
			return true;
		}
		return false;
	}
	
	@Override
	boolean checkRageQuit(){
		if(this.notEarnRageQuit() && !(lv.hasWon())){
			achievements.get("RageQuit").setIsEarned(true);
			popingUp.push("RageQuit");
			return true;
		}
		return false;
	}

	@Override
	boolean checkVictoryLap() {
		if(this.notEarnVictoryLap() && lv.hasWon() && lv.getIsCompleted()){
			achievements.get("VictoryLap").setIsEarned(true);
			popingUp.push("VictoryLap");
			return true;
		}
		return false;
	}

	/*Finish*/
	public void reset() {
		this.lv=null;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();	
	}
}
