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

	public BoardElt(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public int[] getRowCol() {
		int[] ints = {row, col};
		return ints;
	}
	
	
	public void setRowCol(int[] rowcol){
		this.row = rowcol[0];
		this.col = rowcol[1];
	}
	
	@Override
	public abstract String toString();
	
	public String getType() {
		return null;
	}
	

	
}
