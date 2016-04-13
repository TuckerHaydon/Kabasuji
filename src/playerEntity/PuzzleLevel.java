package playerEntity;

public class PuzzleLevel extends Level {
	
	int usedMove;
	int allowedMoves;
	
	public PuzzleLevel(int levelNum, int allowedMoves, Board b, Bullpen bp){
		super(levelNum, b, bp);
		this.allowedMoves = allowedMoves;
		
	}
	
	void updateMoves(int delta){
		usedMove += delta;
	}

	void reset(){
		score = 0;
		usedMove = 0;
	}
	
	/*added by Dorothy for AM uses*/
	public boolean isMoveUsedUp(){
		return usedMove==allowedMoves;
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}
}
