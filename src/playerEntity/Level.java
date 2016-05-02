package playerEntity;

/**
 * Abstract class used to construct levels of a game.
 * There are 15 of these in a game.
 * @author tuckerhaydon, ndiwakar, dgwalder
 * @see PuzzleLevel
 * @see LightningLevel
 * @see ReleaseLevel
 */
public abstract class Level {
	
	Bullpen bullpen;
	Board board;
	boolean isUnlocked;
	int levelNum;
	boolean isComplete;
	
	/**
	 * Level constructor
	 * @param levelNum - which level it is in the game
	 * @param b - the board for the level
	 * @param bp - the bullpen for the level
	 */
	public Level(int levelNum, Board b, Bullpen bp){
		this.levelNum = levelNum;
		this.bullpen = bp;
		this.board = b;
		this.isComplete=false;
	}

	/**
	 * Get the current level number
	 * @return - current level number
	 */
	public int getLevelNum(){
		return this.levelNum;
	}
	
	/**
	 * Set the desired level number
	 * @param i - desired level number
	 */
	public void setLevelNum(int i){
		this.levelNum = i;
	}
	
	/**
	 * Tells you if the level is complete
	 * @return - true if level is complete, false otherwise
	 */
	public boolean getIsCompleted(){
		return isComplete;
	}
	
	/**
	 * Set the level as unlocked so it is playable	
	 * @param u - boolean indicating locked status
	 */
	public void setIsUnlocked(boolean u){
		this.isUnlocked = u;
	}
	
	/**
	 * Tells you if level has been unlocked
	 * @return - boolean indicating locked status
	 */
	public boolean getIsUnlocked(){
		return this.isUnlocked;
	}
	
	/**
	 * Get the level's board
	 * @return - the level's board
	 */
	public Board getBoard(){
		return this.board;
	}
	
	/**
	 * Set the level's board
	 * @param b - the desired board
	 */
	public void setBoard(Board b){
		this.board = b;
	}
	
	/**
	 * Get the level's bullpen
	 * @return - the level's bullpen
	 */
	public Bullpen getBullpen(){
		return this.bullpen;
	}
	
	/**
	 * Set the desired level bullpen
	 * @param bp - the desired bullpen
	 */
	public void setBullpen(Bullpen bp){
	    this.bullpen = bp;
	}
	
	/**
	 * Set the level as complete
	 * @param isComplete - boolean indicating completion
	 */
	public void setLevelComplete(boolean isComplete){
		this.isComplete = isComplete;
	}
	
	/**
	 * Get the number of stars accumulated (this is the score). 
	 * Each level has individual criteria for star awards
	 * @return - number of stars accumulated for a level
	 */
	public abstract int getStars();
	
	/**
	 * Reset the level
	 */
	abstract public void reset();
	
	/**
	 * Get information on level limits
	 * Puzzle - number of moves allotted
	 * Lightning - amount of time allotted
	 * Release - N/A
	 * @return - quantity corresponding to level limit
	 */
	public abstract int getLevelData();
	
	/**
	 * Set level limits
	 * Puzzle - number of moves allotted
	 * Lightning - amount of time allotted
	 * @param levelData - either the number of moves or time based on the level in question
	 */
	public abstract void setLevelData(int levelData);
	
	public abstract boolean cannotContinue();
}
