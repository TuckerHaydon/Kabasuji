package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;

public abstract class LevelView extends View {
	BullpenView bullpenView;
	BoardView boardView;
	JButton goToMenu;
	JLabel score;
	Level level;
	
	abstract void initView();
}
