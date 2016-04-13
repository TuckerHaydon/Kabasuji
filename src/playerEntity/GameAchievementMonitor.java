package playerEntity;

import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import playerController.IMove;
import playerController.NavigateMainMenu;
import playerController.PlayLevel;

public class GameAchievementMonitor {
	int previousLvNum;
	int numConsecutiveLevelsCompleted;
	
	public GameAchievementMonitor(){
		this.numConsecutiveLevelsCompleted=0;
	}
	
	/* Attention : Set before enter the level*/
	public void setPreviousLevel(int num){
		this.previousLvNum=num;
	}
	
	//check in the boardController
	public boolean updateAchievement(Level lv){
		if(this.previousLvNum==lv.getLevelNum()){
			this.numConsecutiveLevelsCompleted++;
		}
		if(this.numConsecutiveLevelsCompleted==3){
			return true;
		}
		return false;
	}
	
	//
	public void pop(){
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "K-komboBreaker!", "Achievement Unlocked:", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//reset when press BackToMainMenu Button
	public void reset(){
		this.numConsecutiveLevelsCompleted=0;
		this.previousLvNum=-999;	
	}
}
