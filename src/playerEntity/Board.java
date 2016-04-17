
package playerEntity;

import java.util.ArrayList;

/**
 * @author kacper
 *
 */

public class Board {  
	ArrayList<Tile> tiles;
	BoardElt[][] elts;
	
	public static int XELTS = 12;
	public static int YELTS = 12;
	
	public Board(BoardElt elts[][]) {
		if(elts.length != XELTS || elts[0].length != YELTS) {
			throw new RuntimeException("Invalid board made");
		}
		this.elts = elts;
	}
	
	//adds a tile to the board
	public boolean addTile(Tile t, int row, int col) {
		((Anchor) t.getSquare(0,0)).setRowCol(row,col);
		for(Square s : t.getSquares()) {
			((PlayableBoardElt) elts[row + s.getRelX()][col + s.getRelY()]).setCovered(true);	
		}
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
	
	public BoardElt getBoardElt(int row, int col){
		return elts[row][col];
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
