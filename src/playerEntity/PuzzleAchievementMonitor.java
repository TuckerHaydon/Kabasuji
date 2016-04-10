package playerEntity;

import java.util.Hashtable;

import playerController.IMove;

public class PuzzleAchievementMonitor extends LevelAchievementMonitor{
	int toBullpenMove;
	PuzzleLevel lv;
	
	
	public PuzzleAchievementMonitor(PuzzleLevel lv, Hashtable<String, Achievement> achievements){
		this.lv=lv;
		this.achievements=achievements;
		this.isillegalMove=false;
		this.moveCounter=0;
		this.toBullpenMove=0;
	}
	
	@Override
	public boolean updateAchievement(IMove move) {
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkJustUnderTheWire(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkNoRegrets(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkRageQuit(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	
}
