package playerController;

import playerEntity.LightningLevel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightningLevelTimer implements ActionListener{
	LightningLevel level;
	
	public LightningLevelTimer(LightningLevel level){
		this.level = level;
	}
	
	public void actionPerformed(ActionEvent evt) {
    	this.level.updateTime(+1);

        if (level.hasWon() || level.isTimeUsedUp()) {
            //TODO find out how to trickle down to lightningLevelView so you can stop timer
        	//timer.stop();
        }
    }    


}
