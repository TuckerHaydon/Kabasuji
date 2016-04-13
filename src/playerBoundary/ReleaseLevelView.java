package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import builderController.NavigateMainMenu;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.ReleaseLevel;

public class ReleaseLevelView extends LevelView{
	JLabel movesLeft;
	GameModel m;
	
	public ReleaseLevelView(ReleaseLevel releaseLevel, GameModel m) {
		this.level = releaseLevel;
		this.m=m;
		goToMenu = new JButton("Main Menu");
		resetLvl = new JButton("Reset Level");
	}

	@Override
	public void initView() {
		//set properties of the view
		this.setSize(1000,1000);
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard(),app,m);
		
		this.add(resetLvl);
		this.add(goToMenu);
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