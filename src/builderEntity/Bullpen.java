package builderEntity;

public class Bullpen {

	Tile tiles[];
	
	Bullpen(Tile tiles[]){
		this.tiles = tiles;
	}
	
	boolean addTile(){
		return true;
	}
	
	boolean remTile(){
		return true;
	}
	
	boolean shiftTiles(int numShift){
		return true; 
	}
}
