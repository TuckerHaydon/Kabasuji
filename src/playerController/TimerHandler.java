package playerController;

import playerEntity.LightningLevel;
import javax.swing.Timer;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LightningLevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * 
 * @author dgwalder
 *
 */
public class TimerHandler implements ActionListener{
	LightningLevel level;
	KabasujiPlayerApplication app;
	
	public TimerHandler(LightningLevel level, KabasujiPlayerApplication app){
		this.level = level;
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent evt) {
		System.out.println("running...");
    	this.level.updateTime(+1);
    	((LightningLevelView) app.getGameWindow().getLevelView()).refreshTimeLabel();

        if (level.hasWon() || level.isTimeUsedUp()) {
        	level.stopTimer();
        }
    }    


}
