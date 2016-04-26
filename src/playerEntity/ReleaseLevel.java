package playerEntity;

import java.awt.Color;
import java.util.ArrayList;

/**
 * 
 * @author tuckerhaydon, dorothy, ndiwakar
 *
 */
public class ReleaseLevel extends Level {

	int numEltLeft;

	public ReleaseLevel(int levelNum, Board b, Bullpen bp){
		super(levelNum, b, bp);
		// this.numEltLeft = numEltLeft;
	}

	public void reset(){
		// Set the score to 0
		score = 0;

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

	public int getNumLeft() {
		return this.numEltLeft;
	}
	/*added by Dorothy*/
	public void decrementNumElt(){
		this.numEltLeft--;
	}

	public boolean isCoverAll(){
		return this.numEltLeft==0;
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param i
	 */
	public void setNumLeft(int i) {
		this.numEltLeft = i;
	}

	@Override
	public String toString(){
		return "Release";
	}

	@Override
	public int getLevelData() {
		return this.getNumLeft();
	}

	@Override
	public void setLevelData(int levelData) {
		this.numEltLeft = levelData;
	}

	public int getStars(){
		int stars= 0;
		int coveredNumElts = 0;
		int totalNumElts = 0;
		int [] blueTracker = new int [7];
		int [] redTracker = new int [7];
		int [] greenTracker = new int [7];
		int redSets = 0;
		int blueSets = 0;
		int greenSets = 0;
		int redTwoStars = 0;
		int blueTwoStars = 0;
		int greenTwoStars = 0;

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

		//////////////////////////////////////////////////////////////////////////
		//if 1 set of 1 color of numbered boards elts is covered, stars = 1;
		
		for(int m = 1; m<7; m++){
			if(redTracker[m] > 0){
				redSets++;
			}
			if(redTracker[m] > 1){
				redTwoStars ++;
			}
		}

		for(int m = 1; m<7; m++){
			if(blueTracker[m] > 0){
				blueSets++;
			}
			if(blueTracker[m] > 1){
				blueTwoStars ++;
			}
		}

		for(int m = 1; m<7; m++){
			if(greenTracker[m] > 0){
				greenSets++;
			}
			if(greenTracker[m] > 1){
				greenTwoStars ++;
			}
		}
		
		if(redSets == 6 || greenSets == 6 || blueSets == 6){
			stars = 1;
		}
		
		//////////////////////////////////////////////////////////////////
		
		//check for two-star condition: at least two sets released

		if(redTwoStars == 6 || greenTwoStars == 6 || blueTwoStars == 6){
			stars = 2;
		}
		
		else if(redSets == 6 && greenSets == 6){
			stars = 2;
		}
		
		else if(redSets == 6 && blueSets == 6){
			stars = 2;
		}
		
		else if(greenSets == 6 && blueSets ==6){
			stars = 2;
		}
		
		///////////////////////////////////////////////////////////////////

		//if all numbered board elts are covered, stars = 3
		if(totalNumElts == coveredNumElts){
			stars = 3;
		}
		
		///////////////////////////////////////////////////////////////////

		return stars;
	}

	@Override
	public boolean cannotContinue() {
		// TODO Auto-generated method stub
		return false;
	}
}
