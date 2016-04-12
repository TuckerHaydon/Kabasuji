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
	
	public boolean isLevelDone(){
		return isCompleted;
	}
	
	void reset(){
		score = 0;
		numEltLeft = 0;		
	}
	
	/*added by Dorothy*/
	public void decrementNumElt(){
		this.numEltLeft--;
	}
	
	public boolean isCoverAll(){
		return this.numEltLeft==0;
	}
}
