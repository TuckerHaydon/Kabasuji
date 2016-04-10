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
	
	Board getBoard(){
		return this.board;
	}
	
	int getLevelNum(){
		return this.levelNum;
	}
	
	String getLevelType(){
		return this.levelType;
	}
	
	void setLevelType(String type){
		this.levelType = type;
	}
	
}
