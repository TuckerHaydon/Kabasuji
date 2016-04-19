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
			for(String key: achievements.keySet()){
				achievements.get(key).reset();
			}
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
