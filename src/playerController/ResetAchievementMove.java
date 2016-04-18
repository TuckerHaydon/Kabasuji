package playerController;

import java.util.Hashtable;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Achievement;

public class ResetAchievementMove implements IMove{
	Hashtable<String, Achievement> achievements;
	
	public ResetAchievementMove(Hashtable<String, Achievement> achievements){
		this.achievements=achievements;
	}
	
	/*Finished*/
	public boolean doMove(KabasujiPlayerApplication app) {
		if(isValid(app)){
			this.achievements.get("BabySteps").reset();
			this.achievements.get("Rebel").reset();
			this.achievements.get("OverAchiever").reset();
			this.achievements.get("SlowPoke").reset();
			this.achievements.get("SpeedyGonzales").reset();
			this.achievements.get("JustUnderTheWire").reset();
			this.achievements.get("NoRegrets").reset();
			this.achievements.get("RageQuit").reset();
			this.achievements.get("K-komboBreaker").reset();
			this.achievements.get("VictoryLap").reset();
			System.out.println("ResetAchievementMove::doMove");
			return true;
		}
		return false;
	}
	
	/*Finished*/
	public boolean isValid(KabasujiPlayerApplication app) {
		if(!achievements.isEmpty()){
			return true;
		}
		return false;
	}
}
