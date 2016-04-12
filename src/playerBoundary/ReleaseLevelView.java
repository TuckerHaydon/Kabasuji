package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;
import playerEntity.ReleaseLevel;

public class ReleaseLevelView extends LevelView{
	JLabel movesLeft;
	
	public ReleaseLevelView(ReleaseLevel relLvl) {
		this.level = relLvl;
		goToMenu = new JButton("Main Menu");
	}

	@Override
	public void initView() {
		// Set properties of the frame
		this.setSize(200,200);
		this.add(goToMenu);
		this.setVisible(true);
	}

}