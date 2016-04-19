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
	int previousLvNum;
	boolean isWonlst[];
	
	public GameAchievementMonitor(Hashtable<String, Achievement> ac){
		previousLvNum=0;
		achievements=ac;
		isWonlst=new boolean[15];
		for(int i=0;i<15;i++){
			isWonlst[i]=false;
		}
	}
	
	//this one goes to playLevel Handler
	public void setPreviousLevel(int num){
		this.previousLvNum=num;
		System.out.println("GAM::setPreviousLevel  "+num);
	}
	
	//goes to complete level handler
	public boolean updateAchievement(int lvNum){
		if(!achievements.get("K-komboBreaker").getisEarned()){
			updateWonlst(lvNum);
			for(int i=0;i<5;i++){
				if(isWonlst[i] && isWonlst[i+5] && isWonlst[i+10]){
					achievements.get("K-komboBreaker").setEarned();
					return true;
				}
			}
		}
		return false;
	}
	
	void updateWonlst(int lvNum){
		if(this.previousLvNum==lvNum){
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
		this.previousLvNum=0;
	}
}
