package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class is in charge of monitor levels
 * @author dorothy
 *
 */
public abstract class LevelAchievementMonitor {
	int moveCounter;
	LinkedList<String> popingUp;
	Hashtable<String, Achievement> achievements;
		
	public abstract boolean updateAchievement_whengotonextlevel();
	public abstract boolean updateAchievement_releaseonbullpen();
	public abstract boolean updateAchievement_releaseonboard();
	public abstract boolean updateAchievement_wheninvalidmove();
	public abstract boolean updateAchievement_whenquit();
	public abstract void setLevel(Level lv);
	public abstract void reset();
	
	abstract boolean checkRageQuit();
	abstract boolean checkVictoryLap();
	/*Finished*/
	protected boolean checkBabySteps(){
		if(this.moveCounter==10 && this.notEarnBabyStep()){
			achievements.get("BabySteps").setIsEarned(true);
			popingUp.push("BabySteps");
			return true;
		}
		return false;
	}
	
	/*Finished*/
	protected boolean checkRebel(){
		if(this.notEarnRebel()){
			achievements.get("Rebel").setIsEarned(true);
			popingUp.push("Rebel");
			return true;
		}
		return false;
	}
	
	/*Finished*/
	protected boolean notEarnBabyStep() {
		return !(achievements.get("SpeedyGonzales").getIsEarned());
	}
	/*Finished*/
	protected boolean notEarnRebel() {
		return !(achievements.get("Rebel").getIsEarned());
	}
	/*Finished*/
	protected boolean notEarnOverAchiever() {
		return !(achievements.get("OverAchiever").getIsEarned());
	}
	/*Finished*/
	protected boolean notEarnSlowPoke() {
		return !(achievements.get("SlowPoke").getIsEarned());
	}
	/*Finished*/
	protected boolean notEarnSpeedyGonzales() {
		return !(achievements.get("SpeedyGonzales").getIsEarned());
	}
	/*Finished*/
	protected boolean notEarnJustUnderTheWire() {
		return !(achievements.get("JustUnderTheWire").getIsEarned());
	}
	/*Finished*/
	protected boolean notEarnNoRegrets() {
		return !(achievements.get("NoRegrets").getIsEarned());
	}
	/*Finished*/
	protected boolean notEarnRageQuit() {
		return !(achievements.get("RageQuit").getIsEarned());
	}
	
	/*Finished*/
	protected boolean notEarnVictoryLap(){
		return !(achievements.get("VictoryLap").getIsEarned());
	}
	
	/*Finished*/
	public void popUpScreen(){
		if(popingUp.size()!=0){
			String message = popingUp.getFirst()+"\n";
			for(int i=1;i<popingUp.size();i++){
				message = message + popingUp.get(i)+"\n";
			}
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, message, "Achievement Unlocked:", JOptionPane.INFORMATION_MESSAGE);
			popingUp.clear();
		}
		else{
			System.err.println("LevelAchievementMonitor::popUpScreen :You should NOT popup things without call UpdateAchievement function");
		}
	}
	
	
}
