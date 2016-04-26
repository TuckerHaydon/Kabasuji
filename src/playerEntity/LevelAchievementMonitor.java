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
	
	/**
	 * 
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_whengotonextlevel();
	/**
	 * 
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_releaseonbullpen();
	/**
	 * 
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_releaseonboard();
	/**
	 * 
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_wheninvalidmove();
	/**
	 * 
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_whenquit();
	/**
	 * Activates the corresponding level monitor to monitor the level
	 * @param lv the current playing level
	 */
	public abstract void setLevel(Level lv);
	/**
	 * reset the level achievement monitor
	 */
	public abstract void reset();
	/**
	 * 
	 * @return true if "RageQuit" was just unlocked
	 */
	abstract boolean checkRageQuit();
	/**
	 * 
	 * @return true if "VictoryLap" was just unlocked
	 */
	abstract boolean checkVictoryLap();
	/**
	 * 
	 * @return true if "BabyStep" was just unlocked
	 */
	protected boolean checkBabySteps(){
		if(this.moveCounter==10 && this.notEarnBabyStep()){
			achievements.get("BabySteps").setIsEarned(true);
			popingUp.push("BabySteps");
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return true if "Rebel" was just unlocked
	 */
	protected boolean checkRebel(){
		if(this.notEarnRebel()){
			achievements.get("Rebel").setIsEarned(true);
			popingUp.push("Rebel");
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return true if "BabyStep" was earned
	 */
	protected boolean notEarnBabyStep() {
		return !(achievements.get("SpeedyGonzales").getIsEarned());
	}
	/**
	 * 
	 * @return true if "Rebel" was earned
	 */
	protected boolean notEarnRebel() {
		return !(achievements.get("Rebel").getIsEarned());
	}
	/**
	 * 
	 * @return true if "OverAchiever" was earned
	 */
	protected boolean notEarnOverAchiever() {
		return !(achievements.get("OverAchiever").getIsEarned());
	}
	/**
	 * 
	 * @return true if "SlowPoke" was earned
	 */
	protected boolean notEarnSlowPoke() {
		return !(achievements.get("SlowPoke").getIsEarned());
	}
	/**
	 * 
	 * @return true if "SpeedyGonzales" was earned
	 */
	protected boolean notEarnSpeedyGonzales() {
		return !(achievements.get("SpeedyGonzales").getIsEarned());
	}
	/**
	 * 
	 * @return true if "JustUnderTheWire" was earned
	 */
	protected boolean notEarnJustUnderTheWire() {
		return !(achievements.get("JustUnderTheWire").getIsEarned());
	}
	/**
	 * 
	 * @return true if "NoRegrets" was earned
	 */
	protected boolean notEarnNoRegrets() {
		return !(achievements.get("NoRegrets").getIsEarned());
	}
	/**
	 * 
	 * @return true if "RageQuit" was earned
	 */
	protected boolean notEarnRageQuit() {
		return !(achievements.get("RageQuit").getIsEarned());
	}
	/**
	 * 
	 * @return true if "VictoryLap" was earned
	 */
	protected boolean notEarnVictoryLap(){
		return !(achievements.get("VictoryLap").getIsEarned());
	}
	
	/**
	 * pop up the achievements just earned
	 */
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
