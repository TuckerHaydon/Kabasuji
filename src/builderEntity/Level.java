package builderEntity;

public class Level {

	Bullpen bullpen;
	Board board;
	int levelNum;
	String levelType;
	
	Level(Bullpen bp, Board board, int levelNum, String levelType){
		this.bullpen = bp;
		this.board = board;
		this.levelNum = levelNum;
		this.levelType = levelType;
	}
	
}
