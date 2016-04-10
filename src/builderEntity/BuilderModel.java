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
	
	public void setLevel(Level lvl){
		this.level = lvl;
	}
	
	Level getLevel(){
		return this.level;
	}
	
	public void setGame(Game g){
		this.game = g;
	}
	
	Game getGame(){
		return this.game;
	}
	
	void setSelectedBoardEltType(String type){
		this.selectedBoardEltType = type;
	}
	
	String getSelectedBoardEltType(){
		return this.selectedBoardEltType;
	}
	
	void setSelectedColor(String c){
		this.selectedColor = c;
	}
	
	String getSelectedColor(){
		return this.selectedColor;
	}
	
	void setSelectedNumber(int num){
		this.selectedNumber = num;
	}
	
	int getSelectedNumber(){
		return this.selectedNumber;
	}
	
	void setTileBank(TileBank tb){
		this.tb = tb;
	}
	
	TileBank getTileBank(){
		return this.tb;
	}
	
	

}
