package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This abstract class is in charge of monitor levels
 * @author dorothy
 * @see LightningAchievementMonitor
 * @see ReleaseAchievementMonitor
 * @see PuzzleAchievementMonitor
 */
public abstract class LevelAchievementMonitor {
	int moveCounter;
	LinkedList<String> popingUp;
	Hashtable<String, Achievement> achievements;
	Level lv;
	/**
	 * Update the achievement status when the user complete a level
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_whencompletelevel();
	/**
	 * Update the achievement status when the user release a tile on the bullpen
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_releaseonbullpen();
	/**
	 * Update the achievement status when the user release a tile on the board
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_releaseonboard();
	/**
	 * Update the achievement status when the user 
	 * @return true if any achievement was just unlocked
	 */
	public abstract boolean updateAchievement_wheninvalidmove();
	/**
	 * Update the achievement status when the user quit the game
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
	 * Check if "RageQuit" achievement was just unlocked
	 * @return true if "RageQuit" was just unlocked
	 */
	abstract boolean checkRageQuit();
	/**
	 * Check if "BabyStep" achievement was just unlocked
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
	 * Check if "Rebel" achievement was just unlocked
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
	 * Check the earned status of BabyStep achievement
	 * @return true if "BabyStep" was earned
	 */
	protected boolean notEarnBabyStep() {
		return !(achievements.get("SpeedyGonzales").getIsEarned());
	}
	/**
	 * Check the earned status of Rebel achievement
	 * @return true if "Rebel" was earned
	 */
	protected boolean notEarnRebel() {
		return !(achievements.get("Rebel").getIsEarned());
	}
	/**
	 * Check the earned status of OverAchiever achievement
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
	 * Check the earned status of SpeedyGonzales achievement
	 * @return true if "SpeedyGonzales" was earned
	 */
	protected boolean notEarnSpeedyGonzales() {
		return !(achievements.get("SpeedyGonzales").getIsEarned());
	}
	/**
	 * Check the earned status of JustUnderTheWire achievement
	 * @return true if "JustUnderTheWire" was not earned
	 */
	protected boolean notEarnJustUnderTheWire() {
		return !(achievements.get("JustUnderTheWire").getIsEarned());
	}
	/**
	 * Check the earned status of NoRegrets achievement
	 * @return true if "NoRegrets" was not earned
	 */
	protected boolean notEarnNoRegrets() {
		return !(achievements.get("NoRegrets").getIsEarned());
	}
	/**
	 * Check the earned status of RageQuit achievement
	 * @return true if "RageQuit" was not earned
	 */
	protected boolean notEarnRageQuit() {
		return !(achievements.get("RageQuit").getIsEarned());
	}

	
	/**
	 * pop up the achievements just earned
	 */
	public void popUpScreen(){
		if(popingUp.size()!=0){
			String message  ="";
			for(int i=0;i<popingUp.size();i++){
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
