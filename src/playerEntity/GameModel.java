package playerEntity;

import java.util.Hashtable;

/**
 * 
 * @author tuckerhaydon, dorothy
 *
 */
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
			this.puzzleAM.setLevel(levels[levelNum]);
			System.out.println("SelectingAM:puzzle:lv num:"+levelNum);
		}
		if(levelNum%3==1){
			this.currentAMNum=2;
			this.lightningAM.reset();
			this.lightningAM.setLevel(levels[levelNum]);
			System.out.println("SelectingAM:lightning:lv num:"+levelNum);
		}
		if(levelNum%3==2){

			this.currentAMNum=3;
			this.releaseAM.reset();
			this.releaseAM.setLevel(levels[levelNum]);
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
