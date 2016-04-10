package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;

public class LevelView extends View {
	BullpenView bullpenView;
	BoardView boardView;
	JButton goToMenu;
	JLabel score;
	Level level;
	
	public LevelView(Level l){
		this.level = l;
	}
}
