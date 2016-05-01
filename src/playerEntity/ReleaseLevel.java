package playerEntity;

import java.awt.Color;
import java.util.ArrayList;

/**
 * This is a type of level in Kabasuji.
 * Pieces are placed on the board with the aim of covering the numbered squares.
 * 
 * Acceptable moves:
 * Bullpen -> board
 * 
 * @author tuckerhaydon, dorothy, ndiwakar, dgwalder
 *
 */
public class ReleaseLevel extends Level {

	int numEltLeft;
	
	/**
	 * Constructor for release level
	 * @param levelNum - number of the level in the game
	 * @param b - the level's board
	 * @param bp - the level's bullpen
	 */
	public ReleaseLevel(int levelNum, Board b, Bullpen bp){
		super(levelNum, b, bp);
	}

	/**
	 * Reset the level and its data
	 */
	public void reset(){

		// Set the number of covered elts left to 0
		numEltLeft = 0;

		// Return all the tiles to the bullpen
		ArrayList<Tile> tiles = this.board.getTiles();
		for(Tile t: tiles){
			bullpen.addTile(t);
		}

		// Reset the board
		this.board.reset();	
	}

	/**
	 * Gets the count of numbered elements left 
	 * @return - the number of uncovered numbered elements left on the board
	 */
	public int getNumLeft() {
		return this.numEltLeft;
	}
	
	/**
	 * Decrements the count of numbered elements left 
	 */
	public void decrementNumElt(){
		this.numEltLeft--;
	}

	/**
	 * Returns true if all numbered elements are covered
	 * @return - boolean indicating number coverage
	 */
	public boolean isCoverAll(){
		return this.numEltLeft==0;
	}


	/**
	 * Sets the count of numbered elements left to the parameter i
	 * @param i - the number of uncovered numbered elements left on the board
	 */
	public void setNumLeft(int i) {
		this.numEltLeft = i;
	}

	/**
	 * Returns the name of the level
	 */
	@Override
	public String toString(){
		return "Release";
	}

	/**
	 * Returns the number of uncovered board elements left
	 */
	@Override
	public int getLevelData() {
		return this.getNumLeft();
	}

	/**
	 * Sets the number of uncovered board elements in the level
	 */
	@Override
	public void setLevelData(int levelData) {
		this.numEltLeft = levelData;
	}

	/**
	 * Get the number of stars accumulated by the player in the level
	 * 1 star: 1 set of numbers (1-6) has been covered
	 * 2 stars: 2 sets of numbers have been covered
	 * 3 stars: All numbers have been covered
	 */
	public int getStars(){
		int stars= 0;
		int coveredNumElts = 0;
		int totalNumElts = 0;
		int [] blueTracker = new int [7];
		int [] redTracker = new int [7];
		int [] greenTracker = new int [7];

		for(int i=0; i< board.elts.length; i++){
			for(int j=0; j< board.elts[0].length; j++){
				
				//check for total number of NumberedBoardElts on board
				if(board.elts[i][j] instanceof NumberedBoardElt){
					totalNumElts++;
					NumberedBoardElt nbElt = (NumberedBoardElt) board.elts[i][j];

					if(nbElt.getCovered()){
						
						//figure out how many have been covered
						coveredNumElts++;
						
						//check for each color. NOTE: indexing starts at 1
						if(nbElt.getColor() == Color.RED){
							redTracker[nbElt.getNum()] = redTracker[nbElt.getNum()] + 1;
						}
						if(nbElt.getColor() == Color.BLUE){
							blueTracker[nbElt.getNum()] = blueTracker[nbElt.getNum()] + 1;
						}
						if(nbElt.getColor() == Color.GREEN){
							greenTracker[nbElt.getNum()] = greenTracker[nbElt.getNum()] + 1;
						}
					}
				}
			}
		}

		int redFlag=0;
		int blueFlag=0;
		int greenFlag=0;
		
		int a=1;
		
		while ( a<7) 
		{
			if(redTracker[a] == 0){
				redFlag = 1;
			}
			if(blueTracker[a] == 0){
				blueFlag = 1;
			}
			if(greenTracker[a] == 0){
				greenFlag = 1;
			}
			a++;
		}
		
		stars = 0;
		
		//if all flags stay at 0, then all board numbered boardElts were covered
		//if 2 flgs are at 0 then 2 complete sets were covered 
		//if 1 flag at 0, then only one complete set was covered 
		if((redFlag + blueFlag + greenFlag) == 0){
			stars = 3;
		}else if((redFlag + blueFlag + greenFlag) == 1){
			stars = 2;
		}
		else if((redFlag+ blueFlag + greenFlag) == 2){
			stars = 1;
		}
		
		return stars;
	}

	@Override
	public boolean cannotContinue() {
		// TODO Auto-generated method stub
		return false;
	}
}
