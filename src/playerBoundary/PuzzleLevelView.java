package playerBoundary;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


import playerController.NavigateMainMenu;

import playerController.LevelController;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.PuzzleLevel;

public class PuzzleLevelView extends LevelView{
	JLabel movesLeft;
	GameModel m;
	
	public PuzzleLevelView(PuzzleLevel puzzleLvl, GameModel m) {
		this.level = puzzleLvl;
		this.m=m;
		
		// Initialize the sub-view components
		bullpenView = new BullpenView(level.getBullpen());
		boardView = new BoardView(level.getBoard(), app, m);
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
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 25, 600, 240);
		add(scrollPane);
		
		// Add the bullpenView to the scrollPane
		scrollPane.setViewportView(bullpenView);
		
		// Add the boardView
		boardView.setBounds(25, 275, 600, 600);
		add(boardView);
		
		JLabel lblNumMovesLeft = new JLabel("Num Moves Left");
		lblNumMovesLeft.setBounds(770, 50, 60, 15);
		add(lblNumMovesLeft);
		
		JLabel lblScoreNStuff = new JLabel("Score n stuff");
		lblScoreNStuff.setBounds(770, 250, 60, 15);
		add(lblScoreNStuff);
		
		
	}
	
	@Override
	public void initControllers(){
		goToMenu.addActionListener(new NavigateMainMenu(app,m));
		//resetLvl.addActionListener(new ResetLevel());

		
		// Init the controllers of the subcomponents
		bullpenView.initControllers();
		boardView.initControllers();
		
		// Init own controllers
		setMouseAdapter(new LevelController());

	}

}