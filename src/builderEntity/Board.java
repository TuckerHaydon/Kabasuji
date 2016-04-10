package builderEntity;


public class Board {
	
	BoardElt elts[][];
	
	Board(BoardElt elts[][]){
		this.elts = elts;
	}
	
	Board() {
		elts = new BoardElt[12][12];
	}
	
	
	//do we even need these methods?
	boolean addTile(Tile t){
		return true;
	}
	
	boolean remTile(){
		return true;
	}

}
