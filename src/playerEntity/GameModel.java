package playerEntity;

import java.util.Hashtable;


public class GameModel {
	Hashtable<String, Achievement> achievements;
	Level[] levels;
	Level currentLevel;	
	GameAchievementMonitor GAM;
	LevelAchievementMonitor lightningAM, puzzleAM, releaseAM;
	int currentAMNum;
	
	public GameModel(){

	}
	
	public void initModel(){


		// Fifteen levels total
		Level[] lev = new Level[15];

		LightningLevel[] lightLevels = new LightningLevel[5];
		ReleaseLevel[] releaseLevels = new ReleaseLevel[5];
		PuzzleLevel[] puzzleLevels = new PuzzleLevel[5];
		
		// Initialize the various levels
//		for(int i = 0; i < 5; i++)
//		{
//			
//			puzzleLevels[i] = new PuzzleLevel(i, 20);
//			puzzleLevels[i].setIsUnlocked(true);
//			
//			lightLevels[i] = new LightningLevel(i, 100);
//			lightLevels[i].setIsUnlocked(true);
//			
//			releaseLevels[i] = new ReleaseLevel(i, 20);
//			releaseLevels[i].setIsUnlocked(true);
//		
//		}
//		
//		// Insert the various levels into the level array
//		for (int i = 0; i<5; i++)
//		{
//			lev[3*i] = puzzleLevels[i];
//			lev[3*i + 1] = lightLevels[i];
//			lev[3*i + 2] = releaseLevels[i];
//			
//		}
//		
//		for (int i = 0; i<15; i++)
//		{
//			lev[i].levelNum = i + 1;
//			
//		}
//		this.levels = lev;
//		this.currentLevel = levels[0];
		
		achievements = new Hashtable<String, Achievement>();
		this.achievements.put("BabySteps", new Achievement("BabySteps"));
		this.achievements.put("Rebel", new Achievement("Rebel"));
		this.achievements.put("OverAchiever", new Achievement("OverAchiever"));
		this.achievements.put("SlowPoke", new Achievement("SlowPoke"));
		this.achievements.put("SpeedyGonzales", new Achievement("SpeedyGonzales"));
		this.achievements.put("JustUnderTheWire", new Achievement("JustUnderTheWire"));
		this.achievements.put("NoRegrets", new Achievement("NoRegrets"));
		this.achievements.put("RageQuit", new Achievement("RageQuit"));
		this.achievements.put("K-komboBreaker", new Achievement("K-komboBreaker"));
		this.achievements.put("VictoryLap", new Achievement("VictoryLap"));
		this.lightningAM = new LightningAchievementMonitor(this.achievements);
		this.puzzleAM = new PuzzleAchievementMonitor(this.achievements);
		this.releaseAM = new ReleaseAchievementMonitor(this.achievements);
		
		//initiate GAM, LAM, PAM, RAM
		this.GAM = new GameAchievementMonitor(this.achievements);
		this.puzzleAM = new PuzzleAchievementMonitor(this.achievements);
		this.releaseAM = new ReleaseAchievementMonitor(this.achievements);
		this.lightningAM = new LightningAchievementMonitor(this.achievements);
		this.currentAMNum=0;
		
		
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
	
	public Hashtable<String, Achievement> getAchievements(){
		return this.achievements;
	}
	
	public GameAchievementMonitor getGAM(){
		return this.GAM;
	}
	
	public void selectCurrentAM(int levelNum){
		if(levelNum%3==0){
			this.currentAMNum=1;
			this.puzzleAM.reset();
			System.out.println("SelectingAM:puzzle:lv num:"+levelNum);
		}
		if(levelNum%3==1){
			this.currentAMNum=2;
			this.lightningAM.reset();
			System.out.println("SelectingAM:lightning:lv num:"+levelNum);
		}
		if(levelNum%3==2){

			this.currentAMNum=3;
			this.releaseAM.reset();
			System.out.println("SelectingAM:release:lv num:"+levelNum);
		}
	}
	
	public LevelAchievementMonitor getCurrentAM(){
		if(this.currentAMNum==1){
			return this.puzzleAM;
		}
		if(this.currentAMNum==2){
			return this.lightningAM;
		}
		if(this.currentAMNum==3){
			return this.releaseAM;
		}
		return null;
	}
}
