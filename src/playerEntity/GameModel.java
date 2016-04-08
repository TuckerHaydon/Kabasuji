package playerEntity;

import java.util.Hashtable;

public class GameModel {
	Hashtable<String, Achievement> achievements;
	
	
	
	
	
	
	public GameModel(){
		
		//Dorothy: those still need pictures
		this.achievements.put("BabySteps", new Achievement("BabySteps",null,null));
		this.achievements.put("Rebel", new Achievement("Rebel",null,null));
		this.achievements.put("OverAchiever", new Achievement("OverAchiever",null,null));
		this.achievements.put("SlowPoke", new Achievement("SlowPoke",null,null));
		this.achievements.put("SpeedyGonzales", new Achievement("SpeedyGonzales",null,null));
		this.achievements.put("JustUnderTheWire", new Achievement("JustUnderTheWire",null,null));
		this.achievements.put("NoRegrets", new Achievement("NoRegrets",null,null));
		this.achievements.put("RageQuit", new Achievement("RageQuit",null,null));
		this.achievements.put("K-komboBreaker", new Achievement("K-komboBreaker",null,null));
		this.achievements.put("VictoryLap", new Achievement("VictoryLap",null,null));
	}
	
}
