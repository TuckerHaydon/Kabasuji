package builderEntity;

import java.util.ArrayList;

public class TileBank {
<<<<<<< HEAD
	
	ArrayList<Tile> tiles;

	TileBank(){}
=======
ArrayList<Tile> tiles;

TileBank(ArrayList<Tile> t){
	this.tiles = t;
}

ArrayList<Tile> getTiles(){
	return this.tiles;
}

void setTiles(ArrayList<Tile> t){
	this.tiles = t;
}
>>>>>>> branch 'master' of https://github.com/TuckerHaydon/Kabasuji-Cebriones


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
