package playerBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;
import playerEntity.PuzzleLevel;

public class PuzzleLevelView extends LevelView{
	JLabel movesLeft;
	
	
	public PuzzleLevelView(PuzzleLevel puzzleLvl) {
		this.level = puzzleLvl;
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard());
		

	}

	@Override
	public void initView() {
		//set properties of the view
		this.setSize(1000,1000);
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