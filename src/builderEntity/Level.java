package builderEntity;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class Level {

	Bullpen bullpen;
	Board board;
	int levelNum;
	String levelType;
	int levelData;
	
	public Level(Bullpen bp, Board board, int levelNum, String levelType, int levelData){;
		this.bullpen = bp;
		this.board = board;
		this.levelNum = levelNum;
		this.levelType = levelType;
		this.levelData = levelData;
	}
	
	public Level(){
		this.bullpen = new Bullpen();
		this.board = new Board();
		this.levelNum = -1;
		this.levelData = -1;
		this.levelType = "Puzzle";
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
