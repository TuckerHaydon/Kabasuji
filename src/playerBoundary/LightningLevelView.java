package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;

import playerEntity.LightningLevel;

public class LightningLevelView extends LevelView{
	JLabel timeLeft; 
	
	public LightningLevelView(LightningLevel lightningLvl) {
		this.level = lightningLvl;
		goToMenu = new JButton("Main Menu");
	}

	@Override
	void initView() {
		this.setSize(200,200);
		this.add(goToMenu);
		this.setVisible(true);
	}
	// can you see me?
}