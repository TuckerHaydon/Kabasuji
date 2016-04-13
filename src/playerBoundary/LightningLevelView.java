package playerBoundary;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerController.NavigateMainMenu;
import playerEntity.GameModel;
import playerEntity.Level;

import playerEntity.LightningLevel;

public class LightningLevelView extends LevelView{
	JLabel timeLeft; 
	GameModel m;
	public LightningLevelView(LightningLevel lightningLvl, GameModel m) {
		this.level = lightningLvl;
		this.m=m;
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard(),app,m);

	}

	@Override
	void initView() {
		//set properties of the view

		// this.setSize(900, 900);
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard(), app, m);
		
	}
	
	@Override
	public void initControllers(){

	}
}