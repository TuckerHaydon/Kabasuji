package playerEntity;

public class PuzzleLevel extends Level {
	
	int usedMove;
	int allowedMoves;
	
	public PuzzleLevel(int levelNum, int allowedMoves){
		super(levelNum);
		this.allowedMoves = allowedMoves;
		
		// TODO probs not this. Want to pass in a file and load a board or something
		this.board = new Board();
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
