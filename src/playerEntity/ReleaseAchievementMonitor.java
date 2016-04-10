package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;

public class ReleaseAchievementMonitor extends LevelAchievementMonitor{
	int numberCovered;
	ReleaseLevel lv;
	
	
	public ReleaseAchievementMonitor(ReleaseLevel lv, Hashtable<String,Achievement> achievements){
		this.lv=lv;
		this.achievements=achievements;
		this.moveCounter=0;
		this.numberCovered=0;
		this.isillegalMove=false;
		this.popingUp=new LinkedList<String>();
	}
	
	@Override
	public boolean updateAchievement(IMove move, KabasujiPlayerApplication app) {
		boolean somethingnew = false;
		return somethingnew;		
	}
	
	
	private boolean checkOverAchiever(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkRageQuit(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
}
