package builderEntity;

/**
 * 
 * Level class
 * 
 * Abstract class used to construct Levels of a game.
 * There are 15 of these in a game.
 * 
 * @see LevelView
 * @see LightningLevel
 * @see PuzzleLevel
 * @see ReleaseLevel
 * 
 * @author tuckerhaydon
 *
 */
public class Level {

	Bullpen bullpen;
	Board board;
	int levelNum;
	String levelType;
	int levelData; //PuzzleLevel - allowedMoves, LightningLevel - allowedTime, ReleaseLevel - no level data
	String levelName;
	
	public static String PUZZLE = "Puzzle";
	public static String LIGHTNING = "Lightning";
	public static String RELEASE = "Release";
	
	/**
	 * Level Constructor
	 * @param bp
	 * @param board
	 * @param levelNum
	 * @param levelType
	 * @param levelData
	 */
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
		this.levelType = RELEASE;
	}
	
	/**
	 * returns the Bullpen of this level
	 * @return Bullpen
	 */
	public Bullpen getBullpen(){
		return this.bullpen;
	}
	
	/**
	 * sets the Bullpen of this level to the given param
	 * @param bp
	 */
	public void setBullpen(Bullpen bp){
		this.bullpen = bp;
	}
	
	/**
	 * sets the name of the level to the given param
	 * @param name
	 */
	public void setLevelName(String name){
		this.levelName = name;
	}
	
	/**
	 * returns the name of the level as type string
	 * @return level name
	 */
	public String getLevelName(){
		return this.levelName;
	}
	
	/**
	 * returns the board of the level
	 * @return board
	 */
	public Board getBoard(){
		return this.board;
	}
	
	/**
	 * sets the board of the level 
	 * @param b
	 */
	public void setBoard(Board b){
		this.board = b;
	}
	
	/**
	 * returns the level num
	 * @return level num
	 */
	public int getLevelNum(){
		return this.levelNum;
	}
	
	/**
	 * sets the level num
	 * @param n
	 */
	public void setLevelNum(int n){
		this.levelNum = n;
	}
	
	/**
	 * returns the type of level as a string 
	 * @return level type 
	 */
	public String getLevelType(){
		return this.levelType;
	}
	
	/**
	 * sets the level type
	 * @param type
	 */
	public void setLevelType(String type){
		this.levelType = type;
	}
	
	/**
	 * returns the level data
	 * PuzzleLevel - allowedMoves
	 * LightningLevel - allowedTime
	 * ReleaseLevel - has no level data
	 * @return level data
	 */
	public int getlevelData(){
		return this.levelData;
	}
	
	/**
	 * sets the level data
	 * PuzzleLevel - allowedMoves
	 * LightningLevel - allowedTime
	 * ReleaseLevel - has no level data 
	 * @param data
	 */
	public void setLevelData(int data){
		this.levelData = data;
	}
	
}
