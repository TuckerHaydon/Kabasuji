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
	
	JLabel movesLeft;
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
		
		/*
		String numMovesLeft = new String (Integer.toString(level.getMovesRemaining()));
		JLabel lblNumMovesLeft = new JLabel("<html>" + "Moves Remaining: " + numMovesLeft + " " + "</html>");
		lblNumMovesLeft.setBounds(770, 400, 60, 300);
		add(lblNumMovesLeft);
		*/
		
		JLabel lblNumMovesLeft = new JLabel("Num Moves Left: ");
		lblNumMovesLeft.setBounds(770, 770, 60, 15);
		add(lblNumMovesLeft);
		
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

}