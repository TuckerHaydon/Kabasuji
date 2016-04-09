package playerEntity;

import java.util.LinkedList;

import playerController.IMove;

public class GameAchievementMonitor {
	LinkedList<Level> levels;
	int numConsecutiveLevelsCompleted;
	
	public GameAchievementMonitor(LinkedList<Level> levels){
		this.levels=levels;
		this.numConsecutiveLevelsCompleted=0;
	}
	
	public void updateAchievements(IMove move){
		//need to be implemented
	}

}
