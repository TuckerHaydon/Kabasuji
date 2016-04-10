package playerEntity;

public class ReleaseLevel extends Level {

	int numEltLeft;
	
	Bullpen bullpen;
	Board board;
	
	int score;
	boolean isUnlocked;
	int levelNum;
	boolean isCompleted;
	
	public ReleaseLevel(int levelNum, int numEltLeft){
		super(levelNum);
		this.numEltLeft = numEltLeft;
	}
	
	int getScore(){
		return score;
	}
	
	boolean isLevelDone(){
		return isCompleted;
	}
	
	void reset(){
		
	}
}
