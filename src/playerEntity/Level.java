package playerEntity;

/**
 * 
 * @author tuckerhaydon
 *
 */
public abstract class Level {
	
	Bullpen bullpen;
	Board board;
	int score;
	boolean isUnlocked;
	int levelNum;
	boolean isComplete;
	
	public Level(int levelNum, Board b, Bullpen bp){
		this.levelNum = levelNum;
		this.bullpen = bp;
		this.board = b;
		this.score = 0;
	}
	
	public int getScore(){
		return score;
	}
	
	abstract public boolean hasWon();
	
	public int getLevelNum(){
		return this.levelNum;
	}
	
	public void setLevelNum(int i){
		this.levelNum = i;
	}
	
	public boolean getIsCompleted(){
		return isComplete;
	}
	
	public void setIsUnlocked(boolean u){
		this.isUnlocked = u;
	}
	
	public boolean getIsUnlocked(){
		return this.isUnlocked;
	}
	
	public Board getBoard(){
		return this.board;
	}
	
	public void setBoard(Board b){
		this.board = b;
	}
	
	public Bullpen getBullpen(){
		return this.bullpen;
	}
	
	public void setBullpen(Bullpen bp){
	    this.bullpen = bp;
	}
	
	abstract public void reset();

	/**
	 * @param i
	 */
	public void setScore(int i) {
		this.score = i;
	}
	
	public abstract int getLevelData();
}
