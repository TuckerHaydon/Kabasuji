package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;
import playerController.TileToBullpenMove;

public class PuzzleAchievementMonitor extends LevelAchievementMonitor{
	int toBullpenMove;
	PuzzleLevel lv;
	
	
	public PuzzleAchievementMonitor(Hashtable<String, Achievement> achievements){
		this.achievements=achievements;
		this.moveCounter=0;
		this.toBullpenMove=0;
		this.popingUp=new LinkedList<String>();
	}
	
	//this one goes to playlevel handler
	public void setLevel(Level lv) {
		reset();
		this.lv=(PuzzleLevel) lv;
	}
	
	//should be called when make a move to the board/bullpen/next level or quit
	public boolean updateAchievement_whengotonextlevel(){
		if(this.checkJustUnderTheWire()||this.checkNoRegrets()||this.checkVictoryLap()){
			return true;
		}
		return false;
	}
	//should goes to bullpen handler when make a new move
	public boolean updateAchievement_whenclickbullpen(){
		this.moveCounter++;
		this.toBullpenMove++;
		return false;
	}
	//should goes to move class
	public boolean updateAchievement_wheninvalidmove(){
		if(this.checkRebel()){
			return true;
		}
		return false;
	}
	//should goes to board handler
	public boolean updateAchievement_whenclickboard(){
		this.moveCounter++;
		if(this.checkRebel()||this.checkBabySteps()){
			return true;
		}
		return false;
	}
	//should goes to Jbutton mainmenu handler
	public boolean updateAchievement_whenquit(){
		if(this.checkRageQuit()){
			return true;
		}
		return false;
	}
	
	/*Finished*/
	private boolean checkJustUnderTheWire(){
		if(lv.isMoveUsedUp() && lv.hasWon() && this.notEarnJustUnderTheWire()){
			achievements.get("JustUnderTheWire").setEarned();
			popingUp.push("JustUnderTheWire");
			return true;
		}
		return false;
	}
	
	/*Finished*/
	private boolean checkNoRegrets(){
		if(lv.hasWon()&& (this.toBullpenMove==0) && this.notEarnNoRegrets()){
			achievements.get("NoRegrets ").setEarned();
			popingUp.push("NoRegrets");
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
	protected void reset() {
		this.lv=null;
		this.toBullpenMove=0;
		this.moveCounter=0;
		this.popingUp=new LinkedList<String>();
	}

}
