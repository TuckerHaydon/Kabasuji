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
		resetLevel = new JButton("Reset Level");
	}

	@Override
	void initView() {
		//set properties of the view
		this.setSize(1000,1000);
		//bullpenView = new BullpenView(level.bullpen);
		//boardView = new BoardView(level.board);
		
		this.add(resetLevel);
		this.add(goToMenu);
		//this.add(bullpenView);
		//this.add(boardView);
		this.setVisible(true);
	}
}