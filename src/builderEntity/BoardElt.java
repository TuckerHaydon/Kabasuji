package builderEntity;

/**
 * BoardElt class
 * 
 * Abstract class used to construct Board Elements.  
 * These are used as a 12x12 array to construct a Board
 * 
 * @see Board
 * @see UnplaybleBoardElt
 * @see PlayableBoardElt
 * @see NumberedBoardElt
 * 
 * @author tuckerhaydon
 *
 */
public abstract class BoardElt {

	int row;
	int col;

	/**
	 * BoardElt constructor
	 * @param row
	 * @param col
	 */
	public BoardElt(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	/** returns the row and col of the board element */
	public int[] getRowCol() {
		int[] ints = {row, col};
		return ints;
	}
	
	/** sets the row and col of the board element */
	public void setRowCol(int[] rowcol){
		this.row = rowcol[0];
		this.col = rowcol[1];
	}
	
	@Override
	public abstract String toString();
	
	/** returns the type of board elt */
	public String getType() {
		return null;
	}
	

	
}
