package builderEntity;

public abstract class BoardElt {

	int row;
	int col;

	BoardElt(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	int[] getRowCol() {
		int[] ints = {row, col};
		return ints;
	}
	
	
	void setRowCol(int[] rowcol){
		this.row = rowcol[0];
		this.col = rowcol[1];
	}
	
}
