
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
	
	@Override
	public String toString(){
		String output = "";
		for(int row = 0; row < elts.length; row++){
			for(int col = 0; col < elts[0].length; col++){
				output += elts[row][col];
				output += " ";
			}
			output += "\n";
		}
		return output;
	}
	
}
