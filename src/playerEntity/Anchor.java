package playerEntity;

/**
 * Anchor class used to store the relative position of squares in a tile,
 * add a tile to a board, or rotate it. An achor stores its board position in row and col
 * @author kacper puczydlowski
 *
 */
public class Anchor extends Square {

	int row;
	int col;
	
	/**
	 * Anchor constructor
	 * The anchor is always has an anchorX and anchorY of (0,0)
	 * @param row row on the board
	 * @param col column on the board
	 * @param t tile to which this Anchor belongs
	 */
	public Anchor(int row, int col, Tile t) {
		super(0, 0, t);
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Returns the row and column as an array
	 * @return the rowcol
	 */
	public int[] getRowCol() {
		int[] ints = {this.row, this.col};
		return ints;
	}
	
	/**
	 * Sets the row and column of the anchor
	 * @param row
	 * @param col
	 */
	public void setRowCol(int row, int col){
		this.row = row;
		this.col = col;
	}
}