package playerController;

import java.util.Hashtable;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Achievement;

/**
 * 
 * @author dorothy
 *
 */
public class ResetAchievementMove implements IMove{
	Hashtable<String, Achievement> achievements;
	boolean[] isReset;
	
	public ResetAchievementMove(Hashtable<String, Achievement> achievements){
		this.achievements=achievements;
		isReset = new boolean[10];
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		
		if(!this.isValid(app)){
			return false;
		}
		
		isReset[0] = this.achievements.get("BabySteps").reset();
		isReset[1] = this.achievements.get("Rebel").reset();
		isReset[2] = this.achievements.get("OverAchiever").reset();
		isReset[3] = this.achievements.get("SlowPoke").reset();
		isReset[4] = this.achievements.get("SpeedyGonzales").reset();
		isReset[5] = this.achievements.get("JustUnderTheWire").reset();
		isReset[6] = this.achievements.get("NoRegrets").reset();
		isReset[7] = this.achievements.get("RageQuit").reset();
		isReset[8] = this.achievements.get("K-komboBreaker").reset();
		isReset[9] = this.achievements.get("VictoryLap").reset();
		System.out.println("ResetAchievementMove::doMove");
		return true;
	}
	
	/*Finished*/
	public boolean isValid(KabasujiPlayerApplication app) {
		if(!achievements.isEmpty()){
			return true;
		}
		return false;
	}
	
	//whoever wrote this can deal with it
	public boolean undo(KabasujiPlayerApplication app) {
		return false;
	}
}
