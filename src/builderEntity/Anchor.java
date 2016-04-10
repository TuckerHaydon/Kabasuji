/**
 * 
 */
package builderEntity;

/**
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
	
	int[] getRowCol() {
		int[] ints = {this.row, this.col};
		return ints;
	}
}
