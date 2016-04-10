package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;

public class LightningAchievementMonitor extends LevelAchievementMonitor{
	boolean slowpoke;
	boolean speedyGonzale;
	LightningLevel lv;
	
	public LightningAchievementMonitor(LightningLevel lv, Hashtable<String,Achievement> achievements){
		this.lv=lv;
		this.isillegalMove=false;
		this.achievements=achievements;
		this.moveCounter=0;
		this.slowpoke=false;
		this.speedyGonzale=false;
		this.popingUp=new LinkedList<String>();
	}
	
	@Override
	public boolean updateAchievement(IMove move, KabasujiPlayerApplication app) {
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkSlowPoke(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
	
	private boolean checkRageQuit(IMove move){
		boolean somethingnew = false;
		return somethingnew;
	}
}
