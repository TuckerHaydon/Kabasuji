package playerEntity;

import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import playerBoundary.KabasujiPlayerApplication;
import playerController.IMove;
import playerController.ReturnToMenuMove;
import playerController.RotateTileClockwiseMove;
import playerController.RotateTileCounterClockwiseMove;
import playerController.TileToBoardMove;
import playerController.TileToBullpenMove;

public abstract class LevelAchievementMonitor {
	int moveCounter;
	LinkedList<String> popingUp;
	Hashtable<String, Achievement> achievements;
		
	public abstract boolean updateAchievement(IMove move);
	
	/*Finished*/
	protected boolean notEarnBabyStep() {
		return !(achievements.get("SpeedyGonzales").getisEarned());
	}
	/*Finished*/
	protected boolean notEarnRebel() {
		return !(achievements.get("Rebel").getisEarned());
	}
	/*Finished*/
	protected boolean notEarnOverAchiever() {
		return !(achievements.get("OverAchiever").getisEarned());
	}
	/*Finished*/
	protected boolean notEarnSlowPoke() {
		return !(achievements.get("SlowPoke").getisEarned());
	}
	/*Finished*/
	protected boolean notEarnSpeedyGonzales() {
		return !(achievements.get("SpeedyGonzales").getisEarned());
	}
	/*Finished*/
	protected boolean notEarnJustUnderTheWire() {
		return !(achievements.get("JustUnderTheWire").getisEarned());
	}
	/*Finished*/
	protected boolean notEarnNoRegrets() {
		return !(achievements.get("NoRegrets").getisEarned());
	}
	/*Finished*/
	protected boolean notEarnRageQuit() {
		return !(achievements.get("RageQuit").getisEarned());
	}
	
	/*Finished*/
	protected boolean checkBabySteps(IMove move){
		if((move instanceof TileToBoardMove)||(move instanceof TileToBullpenMove)
				||(move instanceof RotateTileCounterClockwiseMove)||(move instanceof RotateTileClockwiseMove)){
			this.moveCounter++;
		}
		if(this.moveCounter==10 && this.notEarnBabyStep()){
			achievements.get("BabySteps").setEarned();
			popingUp.push("BabySteps");
			return true;
		}
		return false;
	}
	
	/*Finished*/
	protected boolean checkRebel(IMove move){
		if((move instanceof TileToBoardMove) && this.notEarnRebel()){
			achievements.get("Rebel").setEarned();
			popingUp.push("Rebel");
			return true;
		}
		return false;
	}
	
	abstract boolean checkRageQuit(IMove move);
	
	
	abstract boolean checkVictoryLap(IMove move);
	
	/*Finished*/
	void popUpScreen(){
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
