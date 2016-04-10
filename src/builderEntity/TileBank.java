package builderEntity;

import java.util.ArrayList;

public class TileBank {
	
	ArrayList<Tile> tiles;

	TileBank(){}


//maybe implement as scroll pane instead?

	void shiftTiles(int numShift){
		
	}
	
	boolean addTile(Tile t) {
		return tiles.add(t);
	}
	
	boolean removeTile(Tile t) {
		return tiles.remove(t);
	}
}
