package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import builderController.NavigateMainMenu;
import playerEntity.Level;
import playerEntity.ReleaseLevel;

public class ReleaseLevelView extends LevelView{
	JLabel movesLeft;
	
	public ReleaseLevelView(ReleaseLevel releaseLevel) {
		this.level = releaseLevel;
		goToMenu = new JButton("Main Menu");
		resetLvl = new JButton("Reset Level");
	}

	@Override
	public void initView() {
		//set properties of the view
		
		
	}
	
	@Override
	public void initControllers(){
	}

}