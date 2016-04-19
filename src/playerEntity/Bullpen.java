package playerEntity;

import java.util.ArrayList;

/**
 * 
 * @author kacper
 *
 */
public class Bullpen {

	ArrayList<Tile> tiles;
	public Bullpen(ArrayList<Integer> hexominoes) {
		
		tiles = new ArrayList<Tile>();
		for(Integer i: hexominoes){
			tiles.add(new Tile(i, "Bullpen"));
		}
	}
	
	public boolean addTile(Tile t) {
		return tiles.add(t);
	}
	
	public boolean removeTile(Tile t) {
		return tiles.remove(t);
	}
	
	public ArrayList<Tile> getTiles(){
		return tiles;
	}
}
