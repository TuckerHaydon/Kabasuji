package playerEntity;

import java.util.ArrayList;

import builderController.UndoManager;

/**
 * Board class used for scoring
 * Tiles are added to the board at specific BoardElts
 * These may be playable or numbered (depending on the level)
 * The player interacts with this class through the BoardView boundary
 * @see BoardView
 * @see BoardElt
 * @author kacper puczydlowski, tuckerhaydon
 *
 */
public class Board {  
	ArrayList<Tile> tiles;
	BoardElt[][] elts;
	
	public static int XELTS = 12;
	public static int YELTS = 12;
	
	/**
	 * Board constructor
	 * Creates a board with an empty ArrayList of tiles and a specified 
	 * array of BoardElts
	 * @param elts the specified BoardElts 
	 */
	public Board(BoardElt elts[][]) {
		if(elts.length != XELTS || elts[0].length != YELTS) {
			throw new RuntimeException("Invalid board made");
		}
		tiles = new ArrayList<>();
		this.elts = elts;
	}

	/**
	 * adds a tile to the board
	 * @param t Tile to be added
	 * @param row row of addition
	 * @param col column of addition
	 * @return success
	 */
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

	/**
	 * Removes a Tile from the ArrayList
	 * @param t Tile to be removed
	 * @return success
	 */
	public boolean removeTile(Tile t) {
		return tiles.remove(t);
	}
	
	/**
	 * Removes all Tiles from the ArrayList
	 * @return success
	 */
	public boolean removeAll() {
		return tiles.removeAll(tiles);
	}

	/**
	 * Returns the BoardElts as a 2D array
	 * @return
	 */
	public BoardElt[][] getBoardElts(){
		return elts;
	}

	/**
	 * Returns a BoardElt a specific row col
	 * @param row row of element
	 * @param col column of element
	 * @return the BoardElt
	 */
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

	/**
	 * Returns a Tile at a specified row col
	 * @param row row of Tile
	 * @param col column of Tile
	 * @return
	 */
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
	
	/**
	 * Returns the ArrayList of Tiles
	 * @return
	 */
	public ArrayList<Tile> getTiles(){
		return this.tiles;
	}
	
	/**
	 * Clears all tiles off board and
	 * resets the BoardElts by trying to uncover them all
	 */
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
	
	/**
	 * Equips a Board with a pair of coveralls
	 */
	public void coverAll() {
		// Make sure all of the elements are uncovered
				for(int row = 0; row < YELTS; row++){
					for(int col = 0; col < XELTS; col++){
						BoardElt elt = ((BoardElt)elts[row][col]);
						if(!(elt instanceof UnplayableBoardElt)) {
							((PlayableBoardElt) elt).setCovered(true);
						}
					}
				}
	}
	

}
