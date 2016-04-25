package playerBoundary;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import playerEntity.GameModel;
import playerEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public abstract class LevelView extends View {

	BullpenView bullpenView;
	BoardView boardView;
	JLabel score;
	//Level level;
	JScrollPane scrollPane;
	
	public LevelView(KabasujiPlayerApplication app, GameModel m) {
		super(app, m);
	}
	
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
