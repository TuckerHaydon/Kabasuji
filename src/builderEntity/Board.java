package builderEntity;


public class Board {
	
	BoardElt elts[][];
	
	Board(BoardElt elts[][]){
		this.elts = elts;
	}
	
	Board() {
		elts = new BoardElt[12][12];
	}
	
	void setElts(BoardElt[][] elts){
		this.elts = elts;
	}
	
	BoardElt[][] getElts(){
		return this.elts;
	}
	

}
