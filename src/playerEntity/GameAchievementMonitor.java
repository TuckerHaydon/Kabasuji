package playerEntity;

import java.util.LinkedList;

import playerController.IMove;
import playerController.NavigateMainMenu;
import playerController.PlayLevel;

public class GameAchievementMonitor {
	LinkedList<Level> levels;
	Level currentLevel;
	int numConsecutiveLevelsCompleted;
	
	public GameAchievementMonitor(LinkedList<Level> levels){
		this.levels=levels;
		this.numConsecutiveLevelsCompleted=0;
	}
	
	/* Attention : Set before enter the level*/
	public void setCurrentLevel(Level currentLevel){
		this.currentLevel=currentLevel;
	}
	
	public void updateAchievements(IMove move){
		//need to be implemented
	}

	private boolean checkKomboBreaker(IMove move){
//		if(move instanceof NavigateMainMenu){
//			this.numConsecutiveLevelsCompleted=0;
//		}
//		if(move instanceof PlayLevel)
		return false;
	}
	
	
	
	public void incrementConsecutiveNum(){
		this.numConsecutiveLevelsCompleted++;
	}
	
	
}
