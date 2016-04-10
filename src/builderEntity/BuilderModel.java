package builderEntity;

public class BuilderModel {
	
	Level level;
	Game game;
	String selectedBoardEltType;
	String selectedColor;
	int selectedNumber;
	TileBank tb;
	
	public BuilderModel(){
		this.level = null;
		this.game = null;
		this.selectedBoardEltType = "playable";
		this.selectedNumber = 1;
		this.selectedColor = "red";
	}
	
	public void setlevel(Level lvl){
		this.level = lvl;
	}
	
	public void setGame(Game g){
		this.game = g;
	}
	
	public boolean addTile(Tile t) {
		return tb.addTile(t);
	}

}
