package playerEntity;

import java.util.ArrayList;

/**
 * 
 * @author tuckerhaydon, dorothy
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
}
