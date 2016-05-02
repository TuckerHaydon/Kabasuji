package builderEntity;


/**
 * 
 * Board class
 * 
 * Contains all the BoardElts of the level being built. 
 * BoardElts are deemed playable or unplayable by the Builder. 
 * Playable BoardElts may also be hints or numbered (if a release level is 
 * being built). 
 * The player interacts with this class through the BoardView Boundry class 
 * 
 * @see BoardView
 * @see BoardElt
 * @see BoardController
 * 
 * @author tuckerhaydon
 *
 */
public class Board {
	
	BoardElt elts[][];
	
	/** creates a board with specified board elements */
	public Board(BoardElt[][] elts){
		this.elts = elts;
	}
	/**
	 * Board Constructor
	 * Makes a new board with all playable board elements 
	 */
	public Board(){
		elts = new BoardElt[12][12];
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				elts[row][col] = new PlayableBoardElt(row, col, false);
			}
		}
	}
	
	/** sets the board elements of the board  */
	void setElts(BoardElt[][] elts){
		this.elts = elts;
	}
	
	/** returns the board elements of the board */
	BoardElt[][] getElts(){
		return this.elts;
	}
	
	/** returns the board elements of the board */
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
	
	/** resets numbered board elts */
	public void resetAfterRelease() {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				if(elts[i][j] instanceof NumberedBoardElt) {
					NumberedBoardElt n = (NumberedBoardElt) elts[i][j] ;
					elts[i][j] = new PlayableBoardElt(n.getRowCol()[0],n.getRowCol()[1],n.isHint());
				}
			}
		}
	}
}
