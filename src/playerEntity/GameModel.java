package playerEntity;

import java.util.Hashtable;

public class GameModel {
	Hashtable<String, Achievement> achievements;
	Level[] levels;
	Level currentLevel;	
	GameAchievementMonitor GAM;
	LevelAchievementMonitor currentAM;
	
	public GameModel(){
		//Dorothy: those still need pictures
		achievements = new Hashtable<String, Achievement>();
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
	
	public void initModel(){


		// Fifteen levels total
		Level[] lev = new Level[15];

		LightningLevel[] lightLevels = new LightningLevel[5];
		ReleaseLevel[] releaseLevels = new ReleaseLevel[5];
		PuzzleLevel[] puzzleLevels = new PuzzleLevel[5];
		
		// Initialize the various levels
		for(int i = 0; i < 5; i++)
		{
			
			puzzleLevels[i] = new PuzzleLevel(i, 20);
			puzzleLevels[i].setIsUnlocked(true);
			
			lightLevels[i] = new LightningLevel(i, 100);
			lightLevels[i].setIsUnlocked(true);
			
			releaseLevels[i] = new ReleaseLevel(i, 20);
			releaseLevels[i].setIsUnlocked(true);
		
		}
		
		// Insert the various levels into the level array
		for (int i = 0; i<5; i++)
		{
			lev[3*i] = puzzleLevels[i];
			lev[3*i + 1] = lightLevels[i];
			lev[3*i + 2] = releaseLevels[i];
			
		}
		
		for (int i = 0; i<15; i++)
		{
			lev[i].levelNum = i + 1;
			
		}
		this.levels = lev;
		this.currentLevel = levels[0];
	}
	
	public void setCurrentLevel(int levelNum){
		this.currentLevel = levels[levelNum];
	}
	
	public Level getCurrentLevel(){
		return this.currentLevel;
	}
	
	public Level[] getLevels(){
		return this.levels;
	}
	
	public void setLevels(Level[] l){
		this.levels = l;
	}
	
}
