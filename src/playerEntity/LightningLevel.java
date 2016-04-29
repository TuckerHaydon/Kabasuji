package playerEntity;

import java.util.ArrayList;

import javax.swing.Timer;

/**
 * 
 * @author tuckerhaydon, ndiwakar, dgwalder, kacper puczydlowski
 *
 */
public class LightningLevel extends Level{

	int allowedTime;
	int usedTime;
	Timer timer;

	public LightningLevel(int levelNum, int allowedTime, Board b, Bullpen bp) {
		super(levelNum, b, bp);
		this.allowedTime = allowedTime;
	}

	int getAllowedTime() {
		return this.allowedTime;
	}

	public int getUsedTime() {
		return this.usedTime;
	}

	public int getRemainingTime(){
		return (this.allowedTime - this.usedTime);
	}

	public void updateTime(int delta){
		usedTime += delta;
	}

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

	public boolean isTimeUsedUp(){
		return (this.allowedTime==this.usedTime);
	}
	

	/**
	 * @param i
	 */
	public void setUsedTime(int i) {
		usedTime = i;
	}

	@Override
	public String toString(){
		return "Lightning";
	}

	@Override
	public int getLevelData() {
		return this.usedTime;
	}

	@Override
	public void setLevelData(int levelData) {
		this.usedTime = levelData;
	}

	public void setTimer(Timer t){
		this.timer = t;
	}

	public void startTimer(){
		timer.start();
	}

	public void stopTimer(){
		timer.stop();
	}

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
