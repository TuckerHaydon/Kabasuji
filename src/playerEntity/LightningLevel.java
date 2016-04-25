package playerEntity;

import java.util.ArrayList;

import javax.swing.Timer;

/**
 * 
 * @author tuckerhaydon
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
		score = 0;
		
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

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
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
}
