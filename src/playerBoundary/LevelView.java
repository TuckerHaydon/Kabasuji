package playerBoundary;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import playerEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public abstract class LevelView extends View {
	
	KabasujiPlayerApplication app;
	BullpenView bullpenView;
	BoardView boardView;
	JLabel score;
	Level level;
	JScrollPane scrollPane;
	
	public JScrollPane getScrollPane(){
		return scrollPane;
	}
	
	public BoardView getBoardView(){
		return boardView;
	}
	
	public BullpenView getBullpenView(){
		return bullpenView;
	}
	
}
