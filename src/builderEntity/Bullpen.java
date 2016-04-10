package builderEntity;

import java.util.ArrayList;

public class Bullpen {

	ArrayList<Tile> tiles;
	
	Bullpen(ArrayList<Tile> tiles){
		this.tiles = tiles;
	}
	
	boolean addTile(Tile t){
		return tiles.add(t);
	}
	
	boolean remTile(Tile t){
		return tiles.remove(t);
	}
	
	
	//do we need this method?
	boolean shiftTiles(int numShift){
		return true; 
	}
}
