package playerBoundary;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;

public abstract class LevelView extends View {
	KabasujiPlayerApplication app;
	BullpenView bullpenView;
	BoardView boardView;
	JButton goToMenu;
	JButton resetLvl;
	JLabel score;
	Level level;
	
}
