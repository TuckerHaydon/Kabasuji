package playerEntity;

public abstract class Level {
	
	Bullpen bullpen;
	Board board;
	
	int score;
	boolean isUnlocked;
	int levelNum;
	boolean isComplete;
	
	public Level(int levelNum){
		this.levelNum = levelNum;
	}
	
	int getScore(){
		return score;
	}
	
	public int getLevelNum(){
		return this.levelNum;
	}
	
	public void setLevelNum(int i){
		this.levelNum = i;
	}
	
	public boolean isLevelDone(){
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
	
	void reset(){
		score = 0;
		
	}
}
