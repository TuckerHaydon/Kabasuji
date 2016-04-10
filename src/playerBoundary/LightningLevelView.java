package playerBoundary;

import javax.swing.JLabel;

import playerEntity.Level;

import playerEntity.LightningLevel;

public class LightningLevelView extends LevelView{
	JLabel timeLeft; 
	
	public LightningLevelView(LightningLevel lightningLvl) {
		this.level = lightningLvl;
	}

}
