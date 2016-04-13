package playerEntity;

import java.util.LinkedList;

import playerController.IMove;
import playerController.NavigateMainMenu;
import playerController.PlayLevel;

public class GameAchievementMonitor {
	LinkedList<Level> levels;
	Level previousLevel;
	int numConsecutiveLevelsCompleted;
	
	public GameAchievementMonitor(LinkedList<Level> levels){
		this.levels=levels;
		this.numConsecutiveLevelsCompleted=0;
	}
	
	/* Attention : Set before enter the level*/
	public void setPreviousLevel(Level previousLevel){
		this.previousLevel=previousLevel;
	}
	
	public void updateAchievements(IMove move){
		//need to be implemented
	}
	
	
	public void reset(){
		this.previousLevel=null;
		this.numConsecutiveLevelsCompleted=0;
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
