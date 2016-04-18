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
	
	@Override
	public String toString(){
		String output = "";
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				output+=elts[row][col].toString()+" ";
			}
			output+="\n";
		}
			
		return output;
	}
}
