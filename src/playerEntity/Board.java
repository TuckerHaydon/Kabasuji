
package playerEntity;

import java.util.ArrayList;

/**
 * @author kacper
 *
 */

public class Board {
	ArrayList<Tile> tiles;
	BoardElt[][] elts;
	
	public Board(BoardElt elts[][]) {
		this.elts = elts;
	}
	
	public boolean addTile(Tile t) {
		return tiles.add(t);
	}
	
	public boolean removeTile(Tile t) {
		return tiles.remove(t);
	}

	public boolean removeAll() {
		return tiles.removeAll(tiles);
	}
	
	public BoardElt[][] getBoardElts(){
		return elts;
	}
	
}
