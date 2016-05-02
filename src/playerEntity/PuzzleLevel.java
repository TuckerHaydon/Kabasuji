package playerEntity;

import java.util.ArrayList;

/**
 * This is a type of level in Kabasuji.
 * Pieces are placed on the board with a limit on number of moves available.
 * 
 * Acceptable moves:
 * Bullpen -> board
 * Board -> board
 * Board -> bullpen
 * 
 * @author tuckerhaydon, dorothy, ndiwakar, dgwalder, kacper puczydlowski
 *
 */
public class PuzzleLevel extends Level {
	
	int usedMove;
	int allowedMoves;
	int initScore;
	
	/**
	 * Constructor for puzzle level
	 * @param levelNum - the level in the game (out of 15)
	 * @param allowedMoves - limit on number of moves allotted for the player during gameplay
	 * @param b - the level's board
	 * @param bp - the level's bullpen
	 */
	public PuzzleLevel(int levelNum, int allowedMoves, Board b, Bullpen bp){
		super(levelNum, b, bp);
		this.allowedMoves = allowedMoves;
		this.initScore = bullpen.getTiles().size();
	}
	
	/**
	 * Get the number of moves already used by the player
	 * @return - the number of moves used
	 */
	public int getUsedMoves() {
		return this.usedMove;
	}
	
	/**
	 * Get the number of moves remaining
	 * @return - number of moves remaining for the level
	 */
	public int getMovesRemaining() {
		return (this.allowedMoves - this.usedMove);
	}
	
	/**
	 * Update the number of moves available
	 * @param delta - how many moves the total number of moves left has changed by
	 */
	public void updateMoves(int delta){
		usedMove += delta;
	}
	
	/**
	 * Reset the level and its elements
	 */
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
	
	/**
	 * Check if all the available moves have been used
	 * @return - boolean 
	 */
	public boolean isMoveUsedUp(){
		return usedMove >= allowedMoves;
	}

	/**
	 * Set the number of moves already used by the player in the level
	 * @param i - number of moves used
	 */
	public void setUsedMoves(int i) {
		usedMove = i;
	}
	
	/**
	 * Returns the name of the level
	 */
	@Override
	public String toString(){
		return "Puzzle";
	}

	/**
	 * Get the number of moves allotted for the puzzle level 
	 * (level data is different for each type of level)
	 */
	@Override
	public int getLevelData() {
		return this.usedMove;
	}
	
	/**
	 * Set the number of moves allotted for the puzzlr level
	 */
	@Override
	public void setLevelData(int levelData) {
		this.usedMove = levelData;
	}
	
	/**
	 * Get the number of stars accumulated by the player in the level
	 * 1 star: All but 2 placeable tiles have been placed
	 * 2 stars: All but 1 placeable tile has been placed
	 * 3 stars: All placeable tiles have been placed
	 */
	public int getStars(){
		int stars= 0;
		int coveredElts = 0;
		int totalPbElts = 0;
		int tilesPlaceable = 0;

		for(int i=0; i< board.elts.length; i++){
			for(int j=0; j< board.elts[0].length; j++){
				if(board.elts[i][j] instanceof PlayableBoardElt){
					totalPbElts++;
				}
			}
		}
		
		tilesPlaceable = totalPbElts/6;
				
		if(tilesPlaceable - board.getTiles().size() == 0){
			stars = 3;
		}
		
		if(tilesPlaceable - board.getTiles().size() == 1){
			stars = 2;
		}
		
		if(tilesPlaceable - board.getTiles().size()  == 2){
			stars = 1;
		}
		
		return stars;
	}
	
	/**
	 * Checks if all moves have been used
	 */
	public boolean cannotContinue(){
		return this.isMoveUsedUp();
	}
	
}
