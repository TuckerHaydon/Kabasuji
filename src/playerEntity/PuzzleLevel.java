package playerEntity;

import java.util.ArrayList;

/**
 * 
 * @author tuckerhaydon, dorothy, ndiwakar, dgwalder, kacper puczydlowski
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
		
		if(board.getTiles().size() - tilesPlaceable == 0){
			stars = 3;
		}
		
		if(board.getTiles().size() - tilesPlaceable == 1){
			stars = 2;
		}
		
		if(board.getTiles().size() - tilesPlaceable == 2){
			stars = 1;
		}
		
		return stars;
	}
	
	
	public boolean cannotContinue(){
		return this.isMoveUsedUp();
	}
	
}
