package builderEntity;

public class Level {

	Bullpen bullpen;
	Board board;
	int levelNum;
	String levelType;
	int levelData;
	
	public Level(Bullpen bp, Board board, int levelNum, String levelType){;
		this.bullpen = bp;
		this.board = board;
		this.levelNum = levelNum;
		this.levelType = levelType;
	}
	
	public Level(){
		
	}
	
	public Bullpen getBullpen(){
		return this.bullpen;
	}
	
	public void setBullpen(Bullpen bp){
		this.bullpen = bp;
	}
	
	public Board getBoard(){
		return this.board;
	}
	
	public void setBoard(Board b){
		this.board = b;
	}
	
	public int getLevelNum(){
		return this.levelNum;
	}
	
	public void setLevelNum(int n){
		this.levelNum = n;
	}
	
	public String getLevelType(){
		return this.levelType;
	}
	
	public void setLevelType(String type){
		this.levelType = type;
	}
	
	public int getlevelData(){
		return -1;
	}
	
	public void setLevelData(int data){
		this.levelData = data;
	}
	
}
