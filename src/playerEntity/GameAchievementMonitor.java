package playerEntity;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author dorothy
 *
 */
public class GameAchievementMonitor {
	Hashtable<String, Achievement> achievements;
	int runningLvNum;
	boolean isWonlst[];
	
	public GameAchievementMonitor(Hashtable<String, Achievement> ac){
		runningLvNum=0;
		achievements=ac;
		isWonlst=new boolean[15];
		for(int i=0;i<15;i++){
			isWonlst[i]=false;
		}
	}
	
	/**
	 * Indicates the running level before play the level
	 * @param Level number
	 */
	public void setRunningLevel(int num){
		this.runningLvNum=num;
	}
	
	/**
	 * Check if the number unlocked any achievement
	 * @param lvNum The number represents level
	 * @return True if an achievement is unlocked
	 */
	public boolean updateAchievement(int lvNum){
		if(!achievements.get("K-komboBreaker").getIsEarned()){
			updateWonlst(lvNum-1);
			for(int i=0;i<13;i++){
				if(isWonlst[i] && isWonlst[i+1] && isWonlst[i+2]){
					achievements.get("K-komboBreaker").setIsEarned(true);
					return true;
				}
			}
		}
		return false;
	}
	
	void updateWonlst(int lvNum){
		if(this.runningLvNum==lvNum){
			System.out.println("I am here");
			isWonlst[lvNum]=true;
		}
	}
	
	public void pop(){
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "K-komboBreaker!", "Achievement Unlocked:", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//reset when press BackToMainMenu Button
	public void reset(){
		for(int i=0;i<15;i++){
			isWonlst[i]=false;
		}
		this.runningLvNum=0;
	}
}
