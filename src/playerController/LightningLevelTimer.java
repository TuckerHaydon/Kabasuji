package playerController;

import playerEntity.LightningLevel;
import javax.swing.Timer;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LightningLevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightningLevelTimer implements ActionListener{
	LightningLevel level;
	KabasujiPlayerApplication app;
	
	public LightningLevelTimer(LightningLevel level, KabasujiPlayerApplication app){
		this.level = level;
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent evt) {
    	this.level.updateTime(+1);
    	((LightningLevelView) app.getGameWindow().getLevelView()).getJLabel().repaint();

        if (level.hasWon() || level.isTimeUsedUp()) {
            //TODO find out how to trickle down to lightningLevelView so you can stop timer
        	((LightningLevelView) app.getGameWindow().getLevelView()).getTimer().stop();
        }
    }    


}
