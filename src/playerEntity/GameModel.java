package playerEntity;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import playerEntity.LevelParser;

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
		levels = new Level[15];
		currentLevel = null;
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
	
	public void loadLevel(String path){
		
		try (Scanner fileScanner = new Scanner(new File(path))){
			parseFile(fileScanner);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// this.levels[0] = LevelParser.getLevel(path);
	}
	
	public void parseFile(Scanner fileScanner){
		
		Level lvls[] = new Level[15];
		
		String next;
		int levelNum = 1;
		
		do
		{
			next = fileScanner.next();
			if(next.equals("BeginLevel")){
				Level lvl = parseLevel(fileScanner, levelNum);
				lvl.setIsUnlocked(true);
				lvls[levelNum - 1] = lvl;
			}
			else if(next.equals("EndLevel"))
			{
				levelNum++;
			}
			
		}
		while(!next.equals("EndGame"));
		
		setLevels(lvls);
		
	}
	
	Level parseLevel(Scanner fileScanner, int levelNum){
		
		String levelType = fileScanner.next();
		int levelData = Integer.parseInt(fileScanner.next());
		
		ArrayList<Integer> hexominoes = parseHexominoes(fileScanner);
		BoardElt elts[][] = parseBoardElts(fileScanner);
		
		
		Bullpen bp = new Bullpen(hexominoes);
		Board b = new Board(elts);
		
		// System.out.println(b);
	
		switch(levelType)
		{
			case "Lightning":
				return new LightningLevel(levelNum, levelData, b, bp);
			case "Puzzle":
				return new PuzzleLevel(levelNum, levelData, b, bp);
			case "Release":
				return new ReleaseLevel(levelNum, b, bp);
			default:
				System.err.println("Invalid level type from parser");
				return null;
		}
	}

	BoardElt[][] parseBoardElts(Scanner fileScanner) {
		BoardElt elts[][] = new BoardElt[12][12];
		
		// Parse the BeginElts
		fileScanner.next();
		
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				String input = fileScanner.next();
				BoardElt elt = null;
				
				switch(input.substring(0, 1)){
					// Playable board elt
					case "P":
						// Check if hint
						if(input.length() == 2){ 	elt = new PlayableBoardElt(row, col, true);}
						else{						elt = new PlayableBoardElt(row, col, false);}
						break;
					// Unplayable board elt
					case "U":
						elt = new UnplayableBoardElt(row, col);
						break;
					// Numbered board elt
					case "N":
						// Parse number and color data out
						int num = Integer.parseInt(input.substring(1, 2));
						String c = input.substring(2, 3);
						Color color = null;
						switch(c){
							case "R":
								color = Color.RED;
								break;
							case "B":
								color = Color.BLUE;
								break;
							case "G":
								color = Color.GREEN;
								break;
						}
						// Check if hint
						if(input.length() == 4){	elt = new NumberedBoardElt(row, col, true, color, num);}
						else{						elt = new NumberedBoardElt(row, col, false, color, num);}
						break;
					default:
						System.out.println(input);
				}
				elts[row][col] = elt;
			}
		}
		
		// Parse the EndElts
		fileScanner.next();
		
		return elts;
	}

	ArrayList<Integer> parseHexominoes(Scanner fileScanner) {
		
		ArrayList<Integer> hexominoes = new ArrayList<>();
		
		//Parse the BeginHexominos
		String next = fileScanner.next();
		next = fileScanner.next();

		while(!next.equals("EndHexomino"))
		{
			hexominoes.add(Integer.parseInt(next));
			next = fileScanner.next();	
		}
		
		return hexominoes;
	}
	
	
	
}
