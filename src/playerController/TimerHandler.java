package playerController;

import playerEntity.GameModel;
import playerEntity.LightningLevel;
import javax.swing.Timer;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LightningLevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * Handles the logic of the timer associated with the lightning level
 * @author dgwalder
 * @author tuckerhaydon
 *
 */
public class TimerHandler implements ActionListener{
	LightningLevel level;
	KabasujiPlayerApplication app;
	GameModel m;
	
	public TimerHandler(LightningLevel level, KabasujiPlayerApplication app, GameModel m){
		this.level = level;
		this.app = app;
		this.m = m;
	}
	
	/**
	 * Make sure the timer performs
	 */
	public void actionPerformed(ActionEvent evt) {
    	processAction();
    }
	
	void processAction(){
		
        if (level.getIsCompleted()) {
        	level.stopTimer();
        	return;
        }
		
		this.level.updateTime(+1);
    	((LightningLevelView) app.getGameWindow().getLevelView()).refreshTimeLabel();
        
        if(level.isTimeUsedUp()){
        	level.stopTimer();
        	CompleteLevelMove move = new CompleteLevelMove(app,m);
        	move.execute();
        }
	}


}
