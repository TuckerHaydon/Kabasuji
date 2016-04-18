package builderEntity;


public class Board {
	
	BoardElt elts[][];
	
	public Board(BoardElt elts[][]){
		this.elts = elts;
	}
	
	public Board(){
		elts = new BoardElt[12][12];
		
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				elts[row][col] = new PlayableBoardElt(row, col, false);
			}
		}
	}
	
	void setElts(BoardElt[][] elts){
		this.elts = elts;
	}
	
	public BoardElt[][] getElts(){
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
