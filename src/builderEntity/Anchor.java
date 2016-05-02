package builderEntity;

/**
 *
 * Anchor Class
 * 
 * Used to store the relative position of squares in a tile.
 * Also used to add a tile to a board, or rotate it.
 * An anchor stores its board position in row and col.
 * 
 * @author kacper
 *
 */
public class Anchor extends Square {

	int anchorX;
	int anchorY;
	Tile tile;
	int row;
	int col;
	
	Anchor(int row, int col, Tile t) {
		super(0,0,t);
		this.row = row;
		this.col = col;
	}
	
	/** returns the row and col of the anchor */
	int[] getRowCol() {
		int[] ints = {this.row, this.col};
		return ints;
	}
}
