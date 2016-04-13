package playerBoundary;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerController.NavigateMainMenu;
import playerEntity.Level;

import playerEntity.LightningLevel;

public class LightningLevelView extends LevelView{
	JLabel timeLeft; 
	
	public LightningLevelView(LightningLevel lightningLvl) {
		this.level = lightningLvl;
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard());

	}

	@Override
	void initView() {
		//set properties of the view

		// this.setSize(900, 900);
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard());
		
	}
	
	@Override
	public void initControllers(){

	}
}