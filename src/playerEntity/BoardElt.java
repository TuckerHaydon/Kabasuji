package playerEntity;

/**
 * Board Element
 * Abstract class used to construct a Board
 * These are used as a 12x12 array in the Board Class
 * @see Board
 * @see UnplayableBoardElt
 * @see PlayableBoardElt
 * @see NumberedBoardElt
 * @author kacper puczydlowski
 *
 */
public abstract class BoardElt {
	int row;
	int col;
	
	/**
	 * Board Elt Constructor
	 * specifies the row and column of the element
	 * @param row
	 * @param col
	 */
	BoardElt(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Returns the row and column as a 2x1 array
	 * @return
	 */
	public int[] getRowCol() {
		int[] ints = {row, col};
		return ints;
	}
}
