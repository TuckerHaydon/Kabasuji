package playerEntity;

public class LightningLevel extends Level{

	int allowedTime;
	int usedTime;
	javax.swing.Timer timer;
	
	Bullpen bullpen;
	Board board;
	
	int score;
	boolean isUnlocked;
	int levelNum;
	boolean isCompleted;
	
	public LightningLevel(int levelNum, int allowedTime) {
		super(levelNum);
		this.allowedTime = allowedTime;
	}
	
	void updateTime(int delta){
		usedTime += delta;
	}
	
	int getScore(){
		return score;
	}
	
	public boolean isLevelDone(){
		return isCompleted;
	}
	
	void reset(){
		score = 0;
		usedTime = 0;
	}

}
