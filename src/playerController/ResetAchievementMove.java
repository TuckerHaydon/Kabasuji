package playerController;

import java.util.Hashtable;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Achievement;
import playerEntity.GameModel;

/**
 * 
 * @author dorothy
 *
 */
public class ResetAchievementMove extends Move{
	Hashtable<String, Achievement> achievements;
	boolean[] isReset;
	
	public ResetAchievementMove(KabasujiPlayerApplication app, GameModel m, Hashtable<String, Achievement> achievements){
		super(app, m);
		this.achievements=achievements;
		isReset = new boolean[10];
	}
	
	/*Finished*/
	@Override
	boolean doMove() {
		
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
		return true;
	}
	
	/*Finished*/
	@Override
	boolean isValid() {
		if(!achievements.isEmpty()){
			return true;
		}
		return false;
	}
	
	//whoever wrote this can deal with it
	@Override
	public boolean undo() {
		return false;
	}
}
