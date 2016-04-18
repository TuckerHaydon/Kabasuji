package setup;

import java.util.Hashtable;
import playerEntity.*;

public class Setup {
	
	public Setup() {
	}
	
	static public Hashtable<String, Achievement> createNewAchievementsList(){
		Hashtable<String, Achievement> achievements = new Hashtable<String, Achievement>();
		achievements.put("BabySteps", new Achievement("BabySteps"));
		achievements.put("Rebel", new Achievement("Rebel"));
		achievements.put("OverAchiever", new Achievement("OverAchiever"));
		achievements.put("SlowPoke", new Achievement("SlowPoke"));
		achievements.put("SpeedyGonzales", new Achievement("SpeedyGonzales"));
		achievements.put("JustUnderTheWire", new Achievement("JustUnderTheWire"));
		achievements.put("NoRegrets", new Achievement("NoRegrets"));
		achievements.put("RageQuit", new Achievement("RageQuit"));
		achievements.put("K-komboBreaker", new Achievement("K-komboBreaker"));
		achievements.put("VictoryLap", new Achievement("VictoryLap"));
		return achievements;
	}
	
	static public LightningAchievementMonitor createLAM(){
		return new LightningAchievementMonitor(Setup.createNewAchievementsList());
	}
	
	static public PuzzleAchievementMonitor creatPAM(){
		return new PuzzleAchievementMonitor(Setup.createNewAchievementsList());
	}
	
	static public ReleaseAchievementMonitor createRAM(){
		return new ReleaseAchievementMonitor(Setup.createNewAchievementsList());
	}
	
	
}
