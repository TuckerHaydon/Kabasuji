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
		goToMenu = new JButton("Main Menu");
		resetLevel = new JButton("Reset Level");
	}

	@Override
	public void initView() {
		//set properties of the view
		this.setSize(1000,1000);
		//bullpenView = new BullpenView(level.bullpen);
		//boardView = new BoardView(level.board);
		
		this.add(resetLevel);
		this.add(goToMenu);
		//this.add(bullpenView);
		//this.add(boardView);
		this.setVisible(true);
	}

}