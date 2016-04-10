
package playerEntity;

import java.util.ArrayList;

/**
 * @author kacper
 *
 */

public class Board {
	ArrayList<Tile> tiles;
	BoardElt[][] elts;
	
	Board() {
		elts = new BoardElt[12][12];
	}
	
	boolean addTile(Tile t) {
		tiles.add(t);
		return tiles != null;
	}
	
	boolean removeTile(Tile t) {
		return tiles.remove(t);
	}

	boolean removeAll() {
		return tiles.removeAll(tiles);
	}
	
}
