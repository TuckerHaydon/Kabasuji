package playerEntity;

/**
 * 
 * @author tuckerhaydon, dorothy
 *
 */
public class PuzzleLevel extends Level {
	
	int usedMove;
	int allowedMoves;
	
	public PuzzleLevel(int levelNum, int allowedMoves, Board b, Bullpen bp){
		super(levelNum, b, bp);
		this.allowedMoves = allowedMoves;
		
	}
	
	public int getUsedMoves() {
		return this.usedMove;
	}
	
	void updateMoves(int delta){
		usedMove += delta;
	}

	public void reset(){
		System.out.println("puzzle level reset");
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

	/**
	 * @param i
	 */
	public void setUsedMoves(int i) {
		usedMove = i;
	}
	
	@Override
	public String toString(){
		return "Puzzle";
	}
}
