package playerBoundary;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

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
	JProgressBar pBar;
	JScrollPane scrollPane;
	Level lvl;
	
	public LevelView(KabasujiPlayerApplication app, GameModel m, Level level) {
		super(app, m);
		this.lvl = level;
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
	
	public void refreshProgressBar(){
		this.remove(pBar);
		pBar = new JProgressBar(0,3);
		pBar.setValue(lvl.getStars());
		pBar.setStringPainted(true);
		Border border = BorderFactory.createTitledBorder("Star Progress...");
		pBar.setBorder(border);
		pBar.setBounds(650, 500, 250, 50);
		this.add(pBar);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
	
}
