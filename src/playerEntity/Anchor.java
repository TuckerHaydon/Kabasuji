
/**
 * 
 */
package playerEntity;

/**
 * @author kacper
 *
 */
public class Anchor extends Square {

	int row;
	int col;
	
	public Anchor(int row, int col, Tile t) {
		super(0, 0);
		this.row = row;
		this.col = col;
		this.tile = t;
	}
	
	public int[] getRowCol() {
		int[] ints = {this.row, this.col};
		return ints;
	}
	
	public void setRowCol(int row, int col){
		this.row = row;
		this.col = col;
	}
}