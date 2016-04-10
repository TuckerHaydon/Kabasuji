
package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;
import playerEntity.PuzzleLevel;

public class PuzzleLevelView extends LevelView{
	JLabel movesLeft;
	
	public PuzzleLevelView(PuzzleLevel puzzleLvl) {
		this.level = puzzleLvl;
		goToMenu = new JButton("Main Menu");
	}

}
