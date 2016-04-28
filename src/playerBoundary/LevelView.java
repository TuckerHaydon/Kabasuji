package playerBoundary;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import playerController.PrematureCompleteLevelMove;
import playerEntity.GameModel;
import playerEntity.Level;

/**
 * 
 * @author tuckerhaydon, dgwalder
 *
 */
public abstract class LevelView extends View {

	BullpenView bullpenView;
	BoardView boardView;
	JLabel score;
	JButton completeLevel;
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
		Border border = BorderFactory.createTitledBorder("Star Progress...");
		pBar.setBorder(border);
		if (lvl.getStars() == 0){
			pBar.setIndeterminate(true);
			pBar.setString("No Stars Acheived");
		}
		else{
			pBar.setValue(lvl.getStars());
			pBar.setString(Integer.toString(lvl.getStars())+ "Stars Achieved");		
		}
		pBar.setStringPainted(true);
		pBar.setBounds(650, 500, 250, 50);
		this.add(pBar);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
	
	public void competeLevelButton(){
		completeLevel = new JButton("Complete Level");
		completeLevel.setBounds(650, 600, 250, 33);
		completeLevel.setBackground(new Color(128, 128, 128));
		completeLevel.addActionListener(new PrematureCompleteLevelMove(app, m));
		//TODO make new handler that unlocks next level, brings u to level selection menu
		this.add(completeLevel);
	}
	
}
