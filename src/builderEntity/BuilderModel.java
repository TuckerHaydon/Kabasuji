package builderEntity;

public class BuilderModel {
	
	Level level;
	Game game;
	String selectedBoardEltType;
	String selectedColor;
	int selectedNumber;
	TileBank tb;
	
	public BuilderModel(){
		this.level = new Level();
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
	
		public Game getGame(){
		return this.game;
	}
	
	public void setSelectedBoardEltType(String type){
		this.selectedBoardEltType = type;
	}
	
	public String getSelectedBoardEltType(){
		return this.selectedBoardEltType;
	}
	
	public void setSelectedColor(String c){
		this.selectedColor = c;
	}
	
	public String getSelectedColor(){
		return this.selectedColor;
	}
	
	public void setSelectedNumber(int num){
		this.selectedNumber = num;
	}
	
	public int getSelectedNumber(){
		return this.selectedNumber;
	}
	
	public void setTileBank(TileBank tb){
		this.tb = tb;
	}
	
	public TileBank getTileBank(){
		return this.tb;
	}
	
	public boolean addTile(Tile t) {
		return tb.addTile(t);
	}

}
