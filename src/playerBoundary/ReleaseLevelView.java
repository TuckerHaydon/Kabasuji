package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;
import playerEntity.ReleaseLevel;

public class PuzzleLevelView extends LevelView{
	JLabel movesLeft;
	
	public PuzzleLevelView(ReleaseLevel relLvl) {
		this.level = relLvl;
		goToMenu = new JButton("Main Menu");
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
	}

}