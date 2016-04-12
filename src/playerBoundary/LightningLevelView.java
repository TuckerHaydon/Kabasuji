package playerBoundary;

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

		this.setSize(1000,1000);
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard());
		
		this.add(resetLvl);
		this.add(goToMenu);
		//this.add(bullpenView);
		//this.add(boardView);
		this.setSize(300,200);
		this.add(bullpenView);
		this.add(boardView);
		this.setVisible(true);
	}
	
	@Override
	public void initControllers(){
		goToMenu.addActionListener(new NavigateMainMenu(app));
		//resetLvl.addActionListener(new ResetLevel());
	}
}