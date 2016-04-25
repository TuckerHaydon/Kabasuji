package playerEntity;

import java.util.ArrayList;

import builderController.UndoManager;

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
		tiles = new ArrayList<>();
		this.elts = elts;
	}

	//adds a tile to the board
	public boolean addTile(Tile t, int row, int col) {
		((Anchor) t.getSquare(0,0)).setRowCol(row,col);
		for(Square s : t.getSquares()) {
			
			// Determine the row, col of a square
			// These are negative because the coordinate systems of the tile and the board are backwards
			int squareRow = row - s.getRelY();
			int squareCol = col + s.getRelX();
			
			
			((PlayableBoardElt) elts[squareRow][squareCol]).setCovered(true);	
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

	public Tile getTile(int row, int col){
		
		Tile boardTile = null;
		
		// Iterate through all the tiles on the board
		for(int i = 0; i < tiles.size(); i++){		
			
			// Iterate through all the squares in each tile
			for(int j=0; j<6; j++)
			{
				// Find the row,col of each square
				int square_row = -tiles.get(i).squares[j].anchorRelY + tiles.get(i).anchor.row;
				int square_col = tiles.get(i).squares[j].anchorRelX + tiles.get(i).anchor.col;
							
				// Determine is the row, col of the mouse matches the row,col of the square
				if(square_row == row && square_col == col){
					boardTile = tiles.get(i);
				}
			}
		}
		return boardTile;
	}
	
	public ArrayList<Tile> getTiles(){
		return this.tiles;
	}
	
	public void reset(){
		
		// Clear all of the tiles off of the board
		tiles = new ArrayList<>();
		
		// Make sure all of the elements are uncovered
		for(int row = 0; row < YELTS; row++){
			for(int col = 0; col < XELTS; col++){
				try{
					PlayableBoardElt elt = ((PlayableBoardElt)elts[row][col]);
					elt.setCovered(false);
				}
				catch(Exception e){}
			}
		}
	}

}
