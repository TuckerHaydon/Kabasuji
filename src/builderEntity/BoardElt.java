package builderEntity;

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
	

	
}
