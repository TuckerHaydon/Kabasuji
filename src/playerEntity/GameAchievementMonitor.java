package playerEntity;

import java.util.LinkedList;

import playerController.IMove;
import playerController.NavigateMainMenu;
import playerController.PlayLevel;

public class GameAchievementMonitor {
	LinkedList<Level> levels;
	int previousLvNum;
	int numConsecutiveLevelsCompleted;
	
	public GameAchievementMonitor(LinkedList<Level> levels){
		this.levels=levels;
		this.numConsecutiveLevelsCompleted=0;
	}
	
	/* Attention : Set before enter the level*/
	public void setPreviousLevel(int num){
		this.previousLvNum=num;
	}
	
	public void updateConsecutiveNum(int levelNum){
		if(this.previousLvNum==levelNum){
			this.numConsecutiveLevelsCompleted++;
		}
	}
	
	public void reset(){
		this.numConsecutiveLevelsCompleted=0;
		this.previousLvNum=-999;	
	}
}
