package playerBoundary;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import builderController.NavigateMainMenu;
import playerController.LevelController;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.ReleaseLevel;

public class ReleaseLevelView extends LevelView{
	KabasujiPlayerApplication app;
	JLabel movesLeft;
	GameModel m;
	
	public ReleaseLevelView(ReleaseLevel releaseLevel, GameModel m, KabasujiPlayerApplication app) {
		super();
		this.level = releaseLevel;
		this.m=m;
		this.app = app;
		
		bullpenView = new BullpenView(app, level.getBullpen());
		boardView = new BoardView(level.getBoard(),app,m);
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
		JScrollPane scrollPane = new JScrollPane(bullpenView, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(25, 25, 850, 7*bullpenView.getSquareWidth());
		add(scrollPane);
		
		
		// Add the boardView
		boardView.setBounds(25, 8*bullpenView.getSquareWidth(), 12*bullpenView.getSquareWidth(), 12*bullpenView.getSquareWidth());
		add(boardView);
		
		JLabel lblNumMovesLeft = new JLabel("Not sure about this stuff");
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
		setMouseAdapter(new LevelController());
	}

}