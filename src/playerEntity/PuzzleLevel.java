package playerEntity;

import java.util.ArrayList;

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
		
		// Set the score to 0
		score = 0;
		
		// Set the number of moves used to 0
		usedMove = 0;
		
		// Return all the tiles to the bullpen
		ArrayList<Tile> tiles = this.board.getTiles();
		for(Tile t: tiles){
			bullpen.addTile(t);
		}
		
		// Reset the board
		this.board.reset();
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

	@Override
	public int getLevelData() {
		return this.usedMove;
	}

	@Override
	public void setLevelData(int levelData) {
		this.usedMove = levelData;
	}
}
