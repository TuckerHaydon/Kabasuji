
package playerEntity;

import java.util.ArrayList;

/**
 * @author kacper
 *
 */

public class Board {
	ArrayList<Tile> tiles;
	BoardElt[][] elts;
	
	public Board() {
		elts = new BoardElt[12][12];
		
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				elts[row][col] = new PlayableBoardElt(row, col, false);
			}
		}
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
