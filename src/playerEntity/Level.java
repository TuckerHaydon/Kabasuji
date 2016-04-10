package playerEntity;

public abstract class Level {
	
	Bullpen bullpen;
	Board board;
	
	int score;
	public boolean isUnlocked;
	int levelNum;
	boolean isComplete;
	
	public Level(int levelNum){
		this.levelNum = levelNum;
	}
	
	int getScore(){
		return score;
	}
	
	
	public boolean isLevelDone(){
		return isComplete;
	}
	
	public void setIsUnlocked(boolean u){
		this.isUnlocked = u;
	}
	
	public boolean getIsUnlocked(){
		return this.isUnlocked;
	}
	
	void reset(){
		score = 0;
		
	}
}
