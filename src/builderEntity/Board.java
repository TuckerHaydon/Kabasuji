package builderEntity;


public class Board {
	
	BoardElt elts[][];
	
	Board(BoardElt elts[][]){
		this.elts = elts;
	}
	
	
	void setElts(BoardElt[][] elts){
		this.elts = elts;
	}
	
	BoardElt[][] getElts(){
		return this.elts;
	}
	

	public BoardElt[][] getBoardElts(){
		return this.elts;
	}
}
