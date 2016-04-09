/**
 * 
 */
package playerEntity;

import java.util.ArrayList;

/**
 * @author kacper
 *
 */
public class Bullpen {

	/**
	 * 
	 */
	ArrayList<Tile> tiles;
	public Bullpen(ArrayList<Tile> t) {
		tiles = t;
	}
	
	boolean addTile(Tile t) {
		return tiles.add(t);
	}
	
	boolean removeTile(Tile t) {
		return tiles.remove(t);
	}
	
	void shiftTiles(int num) {
		
	}
}
