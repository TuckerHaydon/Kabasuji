package playerEntity;

import java.util.ArrayList;

/**
 * 
 * @author tuckerhaydon, dorothy, ndiwakar, dgwalder
 *
 */
public class PuzzleLevel extends Level {
	
	int usedMove;
	int allowedMoves;
	int initScore;
	
	public PuzzleLevel(int levelNum, int allowedMoves, Board b, Bullpen bp){
		super(levelNum, b, bp);
		this.allowedMoves = allowedMoves;
		this.initScore = bullpen.getTiles().size();
	}
	
	public int getUsedMoves() {
		return this.usedMove;
	}
	
	public int getMovesRemaining() {
		return (this.allowedMoves - this.usedMove);
	}
	
	public void updateMoves(int delta){
		usedMove += delta;
	}

	public void reset(){
		
		// Set the score to 0
		//score = 0;
		
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
		return usedMove >= allowedMoves;
	}
	/*
	@Override
	public boolean hasWon() {
		// TODO Finalize hasWon logic
	
		if(this.getStars() == 3){
			isComplete = true;
			return true;
		}
		return false;
	}*/

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
	
	public int getStars(){
		int remScore = 0;
		int star = 0;
		
		remScore = this.bullpen.getTiles().size();
		//score = initScore - remScore;
		
		if (remScore == 2){
			star = 1;
		}
		else if (remScore == 1){
			star = 2;
		} else if( remScore == 0){
			star = 3;
		}
		
		if(star >0){
			isComplete = true;
		}
		
		return star;
	}
	
	public boolean cannotContinue(){
		return this.isMoveUsedUp();
	}
	
}
