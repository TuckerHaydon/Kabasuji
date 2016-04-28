package playerBoundary;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import playerController.LevelController;
import playerEntity.GameModel;
import playerEntity.PuzzleLevel;

/**
 * 
 * @author tuckerhaydon, dgwalder
 *
 */
public class PuzzleLevelView extends LevelView{
	
	JLabel movesLabel;
	JLabel scoreLabel;
	PuzzleLevel level;
	
	public PuzzleLevelView(KabasujiPlayerApplication app, GameModel m, PuzzleLevel puzzleLvl) {
		super(app, m, puzzleLvl);
		level = puzzleLvl;
		
		// Initialize the sub-view components
		bullpenView = new BullpenView(app, m, level.getBullpen());
		boardView = new BoardView(app, m, level.getBoard());
	}

	@Override
	public void initView() {
		
		// Init the subcomponets views
		bullpenView.initView();
		boardView.initView();
		
		//set properties of the view
		this.setSize(900, 900);
		
		// No layout; using exact coordinates.
		setLayout(null);
		
		// Create the scrollPane
		scrollPane = new JScrollPane(bullpenView, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(25, 25, 850, 7*bullpenView.getSquareWidth());
		add(scrollPane);
		
		// Add the boardView
		boardView.setBounds(25, 8*bullpenView.getSquareWidth(), 12*bullpenView.getSquareWidth(), 12*bullpenView.getSquareWidth());
		add(boardView);
		
		// Add  the moves label
		movesLabel = new JLabel("<html>" + "Moves Remaining: " + (Integer.toString(level.getMovesRemaining())) + " " + "</html>");
		movesLabel.setBounds(650, 400, 150, 100);
		add(movesLabel);
		
		/*
		// Add  the score label
		scoreLabel = new JLabel("<html>" + "Current Score: " + (Integer.toString(level.getScore())) + " " + "</html>");
		scoreLabel.setBounds(650, 500, 150, 300);
		add(scoreLabel);
		*/
		
		//3 stars hence that max and min
		pBar = new JProgressBar(0,3);
		Border border = BorderFactory.createTitledBorder("Star Progress...");
		pBar.setBorder(border);
		if (lvl.getStars() == 0){
			pBar.setIndeterminate(true);
			pBar.setString("No Stars Acheived");
		}
		else{
			pBar.setValue(lvl.getStars());
			pBar.setString(Integer.toString(lvl.getStars())+ "Stars Acheived");
		}	
		pBar.setStringPainted(true);
		pBar.setBounds(650, 500, 250, 50);
		add(pBar);
		
		
		setBackground(new Color(255, 228, 225));
		
	}
	
	@Override
	public void initControllers(){
		
		// Init the controllers of the subcomponents
		bullpenView.initControllers();
		boardView.initControllers();
		
		// Init own controllers
		setMouseAdapter(new LevelController(app, m, app.getGameWindow().getLevelView()));

	}

	//TODO need to implement the refresh move after each move to the board
	public void refreshMoveLabel(){
		this.remove(movesLabel);
		movesLabel = new JLabel("<html>" + "Moves Remaining: " + (Integer.toString(level.getMovesRemaining())) + " " + "</html>");
		movesLabel.setBounds(650, 400, 150, 100);
		this.add(movesLabel, 0);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
	
	/*
	public void refreshScoreLabel(){
		this.remove(scoreLabel);
		scoreLabel = new JLabel("<html>" + "Current Score: " + (Integer.toString(level.getScore())) + " " + "</html>");
		scoreLabel.setBounds(650, 500, 150, 100);
		this.add(scoreLabel,0);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
	*/
	
}