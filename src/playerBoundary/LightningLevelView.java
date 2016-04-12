package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

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
		this.setSize(300,200);
		this.add(bullpenView);
		this.add(boardView);
		this.setVisible(true);
	}
	
	@Override
	public void initControllers(){
		//goToMenu.addActionListener(new NavigateMainMenu(app));
		//resetLvl.addActionListener(new ResetLevel());
	}
}