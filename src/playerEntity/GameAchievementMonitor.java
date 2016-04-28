package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

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
	LinkedList<String> popingUp;
	boolean isWonlst[];
	boolean doubleWonlst[];
	
	public GameAchievementMonitor(Hashtable<String, Achievement> ac){
		runningLvNum=0;
		achievements=ac;
		isWonlst=new boolean[15];
		doubleWonlst=new boolean[15];
		for(int i=0;i<15;i++){
			isWonlst[i]=false;
			doubleWonlst[i]=false;
		}
		this.popingUp=new LinkedList<String>();
	}
	
	/**
	 * Indicates the running level before play the level
	 * @param Level number
	 */
	public void setRunningLevel(int num){
		this.runningLvNum=num;
	}
	
	/**
	 * Check if the number unlocked any achievements
	 *
	 */
	public void updateAchievement(int lvNum){
			updateWonlst(lvNum-1);
			this.checkKomboBreaker();
			this.checkVictoryLap();
	}
	
	/**
	 * Check K-komboBreaker achievement was just earned
	 * @return true if K-komboBreaker achievement was earned 
	 */
	private boolean checkKomboBreaker(){
		if(!achievements.get("K-komboBreaker").getIsEarned()){
			for(int i=0;i<13;i++){
				if(isWonlst[i] && isWonlst[i+1] && isWonlst[i+2]){
					achievements.get("K-komboBreaker").setIsEarned(true);
					popingUp.add("K-komboBreaker");
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Check VictoryLap achievement was just earned
	 * @return true if VictoryLap achievement was earned 
	 */
	private boolean checkVictoryLap(){
		if(!achievements.get("VictoryLap").getIsEarned()){
			for(int i=0;i<15;i++){
				if(isWonlst[i] && doubleWonlst[i]){
					achievements.get("VictoryLap").setIsEarned(true);
					popingUp.add("VictoryLap");
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Update the winning status of each level 
	 * @param lvNum
	 */
	private void updateWonlst(int lvNum){
		if(this.runningLvNum==lvNum){
			if(isWonlst[lvNum]==true){
				doubleWonlst[lvNum]=true;
			}
			else{
				isWonlst[lvNum]=true;
			}
		}
	}
	
	/**
	 * Prompt up message showing the achievements just earned
	 */
	public void pop(){
		if(popingUp.size()!=0){
			String message  ="";
			for(int i=0;i<popingUp.size();i++){
				message = message + popingUp.get(i)+"\n";
			}
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, message, "Achievement Unlocked:", JOptionPane.INFORMATION_MESSAGE);
			popingUp.clear();
		}
	}
		
	/**
	 * Reset the game achievement monitor
	 */
	public void reset(){
		for(int i=0;i<15;i++){
			isWonlst[i]=false;
			doubleWonlst[i]=false;
		}
		this.runningLvNum=0;
		this.popingUp.clear();
	}
}
