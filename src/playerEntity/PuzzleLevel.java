package playerEntity;

public class PuzzleLevel extends Level {
	
	int usedMove;
	int allowedMoves;
	
	Bullpen bullpen;
	Board board;
		
	int score;
	boolean isUnlocked;
	int levelNum;
	boolean isCompleted;
	
	public PuzzleLevel(int levelNum, int allowedMoves){
		super(levelNum);
		this.allowedMoves = allowedMoves;
	}
	
	void updateMoves(int delta){
		usedMove += delta;
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
