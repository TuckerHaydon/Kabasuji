package playerEntity;

public abstract class Level {
	
	Bullpen bullpen;
	Board board;
	
	int score;
	boolean isUnlocked;
	int levelNum;
	boolean isComplete;
	
	public Level(int levelNum){
		this.levelNum = levelNum;
	}
	
	int getScore(){
		return score;
	}
	
	boolean isLevelDone(){
		return isComplete;
	}
	
	void reset(){
		score = 0;
		
	}
}
