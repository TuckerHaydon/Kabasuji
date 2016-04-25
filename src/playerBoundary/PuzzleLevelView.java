package playerBoundary;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import playerController.LevelController;
import playerEntity.GameModel;
import playerEntity.PuzzleLevel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class PuzzleLevelView extends LevelView{
	
	JLabel movesLabel;
	PuzzleLevel level;
	
	public PuzzleLevelView(KabasujiPlayerApplication app, GameModel m, PuzzleLevel puzzleLvl) {
		super(app, m);
		this.level = puzzleLvl;
		
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
		
		movesLabel = new JLabel("<html>" + "Moves Remaining: " + (Integer.toString(level.getMovesRemaining())) + " " + "</html>");
		movesLabel.setBounds(770, 400, 60, 300);
		add(movesLabel);
		
		
		JLabel lblScoreNStuff = new JLabel("Score n stuff");
		lblScoreNStuff.setBounds(770, 850, 60, 15);
		add(lblScoreNStuff);
		
		setBackground(new Color(255, 228, 225));
		
	}
	
	@Override
	public void initControllers(){
		
		// Init the controllers of the subcomponents
		bullpenView.initControllers();
		boardView.initControllers();
		
		// Init own controllers
		System.out.println(app == null);
		setMouseAdapter(new LevelController(app, m, app.getGameWindow().getLevelView()));

	}

	//TODO need to implement the refresh move after each move to the board
	public void refreshMovesLabel(){
		this.remove(movesLabel);
		movesLabel = new JLabel("<html>" + "Moves Remaining: " + (Integer.toString(level.getMovesRemaining())) + " " + "</html>");
		movesLabel.setBounds(650, 400, 150, 300);
		this.add(movesLabel, 0);
		this.getParent().revalidate();
		this.getParent().repaint();
	}
}