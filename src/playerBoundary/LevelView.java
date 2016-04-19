package playerBoundary;

import javax.swing.JLabel;

import playerEntity.Level;

public abstract class LevelView extends View {
	
	KabasujiPlayerApplication app;
	BullpenView bullpenView;
	BoardView boardView;
	JLabel score;
	Level level;
	
}
