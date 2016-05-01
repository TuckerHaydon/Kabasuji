package playerEntity;

import java.util.ArrayList;

import javax.swing.Timer;

/**
 * This is a type of level in Kabasuji.
 * The lightning level has a time limit (seconds)
 * and tiles can be placed on the board in an overlapping fashion.
 * Once placed, the tile disappears and simply leaves its trace.
 * 
 * Acceptable moves:
 * Bullpen -> board
 * 
 * @author tuckerhaydon, ndiwakar, dgwalder, kacper puczydlowski
 *
 */
public class LightningLevel extends Level{

	int allowedTime;
	int usedTime;
	Timer timer;

	/**
	 * Constructor for lightning level
	 * @param levelNum - the number of the level in the game
	 * @param allowedTime - the amount of time allotted to finish the level
	 * @param b - the level's board
	 * @param bp - the level's bullpen
	 */
	public LightningLevel(int levelNum, int allowedTime, Board b, Bullpen bp) {
		super(levelNum, b, bp);
		this.allowedTime = allowedTime;
	}

	/**
	 * Get the amount of time allotted for the player to finish the level
	 * @return - the amount of allowed time
	 */
	int getAllowedTime() {
		return this.allowedTime;
	}
	
	/**
	 * Get the amount of time already used by the player during game play
	 * @return - the amount of time used
	 */
	public int getUsedTime() {
		return this.usedTime;
	}

	/**
	 * Get the amount of time remaining in the level
	 * @return - amount of time remaining in level
	 */
	public int getRemainingTime(){
		return (this.allowedTime - this.usedTime);
	}
	
	/**
	 * Update the amount of time in the level
	 * @param delta - change in time
	 */
	public void updateTime(int delta){
		usedTime += delta;
	}

	/**
	 * Reset the level
	 */
	public void reset(){
		// Set the score to 0
		//score = 0;

		// Set the usedTime to 0
		usedTime = 0;

		// Return all the tiles to the bullpen
		ArrayList<Tile> tiles = this.board.getTiles();
		for(Tile t: tiles){
			bullpen.addTile(t);
		}

		timer.start();

		// Reset the board
		this.board.reset();

	}

	/**
	 * Tell you if all the time for the level has been used up
	 * @return - true if time is all used up
	 */
	public boolean isTimeUsedUp(){
		return (this.allowedTime==this.usedTime);
	}

	/**
	 * Set the amount of time that has been used
	 * @param i - time used
	 */
	public void setUsedTime(int i) {
		usedTime = i;
	}

	/**
	 * Name of the level
	 */
	@Override
	public String toString(){
		return "Lightning";
	}

	/**
	 * Get the level limit attribute (for lightning it is time used)
	 */
	@Override
	public int getLevelData() {
		return this.usedTime;
	}

	/**
	 * Set the amount of time available
	 */
	@Override
	public void setLevelData(int levelData) {
		this.usedTime = levelData;
	}

	/**
	 * Set the timer on the level
	 * @param t - a timer
	 */
	public void setTimer(Timer t){
		this.timer = t;
	}

	/**
	 * Start the timer
	 */
	public void startTimer(){
		timer.start();
	}

	/**
	 * Stop the timer
	 */
	public void stopTimer(){
		timer.stop();
	}

	/**
	 * Get the number of stars accumulated by the player during gameplay
	 */
	public int getStars(){
		int stars= 0;
		int coveredElts = 0;
		int totalElts = 0;

		for(int i=0; i< board.elts.length; i++){
			for(int j=0; j< board.elts[0].length; j++){
				if(board.elts[i][j] instanceof PlayableBoardElt){
					totalElts++;
					PlayableBoardElt pbElt = (PlayableBoardElt) board.elts[i][j];
					if(pbElt.getCovered()){
						coveredElts++;
					}
				}
			}
		}
		
		//if all playable board elts are covered, stars = 3
		//if total playable elts - covered playable elts = 6, stars = 2;
		//if total playable elts - covered playable elts = 12, stars = 1;
		
		if(totalElts == coveredElts){
			stars = 3;
		}
		else if(totalElts - coveredElts <= 6){
			stars = 2;
		}
		else if(totalElts - coveredElts <= 12){
			stars = 1;
		}
		
		return stars;
	}

	@Override
	public boolean cannotContinue() {
		return this.isTimeUsedUp();
	}
}
