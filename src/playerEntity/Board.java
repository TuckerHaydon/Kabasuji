package playerEntity;

import java.util.ArrayList;

/**
 * @author kacper, tuckerhaydon
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

	public boolean empty(){
		boolean isEmpty = false;
		if(tiles == null){
			isEmpty = true;
		}
		return isEmpty;
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

	public Tile getTile(int row, int col){

		Tile boardTile = null;

		for(int i = 0; i < tiles.size(); i++){			
			if((tiles.get(i).anchor.row == row) && (tiles.get(i).anchor.col == col)){
				boardTile = tiles.get(i);
			}
			else{
				for(int j=0; j<6; j++)
				{
					int square_row = tiles.get(i).squares[j].anchorRelX + tiles.get(i).anchor.row;
					int square_col = tiles.get(i).squares[j].anchorRelY + tiles.get(i).anchor.col;

					if(square_row == row && square_col == col){
						boardTile = tiles.get(i);
					}
				}
			}
		}

		return boardTile;
	}

}
