package builderEntity;

public class Level {

	Bullpen bullpen;
	Board board;
	int levelNum;
	String levelType;
	
	public Level(Bullpen bp, Board board, int levelNum, String levelType){
		this.bullpen = bp;
		this.board = board;
		this.levelNum = levelNum;
		this.levelType = levelType;
	}
	
	public Level(){
		
	}
	
	Bullpen getBullpen(){
		return this.bullpen;
	}
	
	void setBullpen(Bullpen bp){
		this.bullpen = bp;
	}
	
	Board getBoard(){
		return this.board;
	}
	
	void setBoard(Board b){
		this.board = b;
	}
	
	int getLevelNum(){
		return this.levelNum;
	}
	
	void setLevelNum(int n){
		this.levelNum = n;
	}
	
	String getLevelType(){
		return this.levelType;
	}
	
	void setLevelType(String type){
		this.levelType = type;
	}
	
}
