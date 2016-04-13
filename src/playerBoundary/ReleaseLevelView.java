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
		this.setSize(1000,1000);
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard(),app,m);
		
		
	}
	
	@Override
	public void initControllers(){
	}

}