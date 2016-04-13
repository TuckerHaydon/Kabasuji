package playerBoundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import playerController.NavigateMainMenu;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;


public class GameWindow extends JFrame {
	
	LevelView currentLevelView;
	TileView draggedTile;
	KabasujiPlayerApplication app;
	GameModel m;
	JButton menuButton;
	JButton resetButton;
	JPanel contentPane;
	
	public GameWindow(KabasujiPlayerApplication app, GameModel m)
	{
		super();
		this.app = app;
		this.m = m;

		// Initialize the buttons
		menuButton = new JButton("Main Menu");
		resetButton = new JButton("Reset Level");
		
		// TODO NOT THIS
		Level currLev = m.getCurrentLevel();
		int currLevNum = currLev.getLevelNum();
		if(currLevNum == 1 || currLevNum == 4 || currLevNum == 7 || currLevNum == 10 || currLevNum == 13){
			currentLevelView = new PuzzleLevelView((PuzzleLevel)currLev);
		}
		else if(currLevNum == 2 || currLevNum == 5 || currLevNum == 6 || currLevNum == 11 || currLevNum == 14){
			currentLevelView = new LightningLevelView((LightningLevel)currLev);
		}
		else if(currLevNum == 3 || currLevNum == 6 || currLevNum == 9 || currLevNum == 12 || currLevNum == 15){
			currentLevelView = new ReleaseLevelView((ReleaseLevel)currLev);
		}
	}
	
	public void initView(){
		
		// Init sub components
		this.currentLevelView.initView();
		
		// Set Frame properties
		this.setSize(1000, 1000);
		this.setTitle("Game Window");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuButton.setBounds(5, 5, 100, 33);
		contentPane.add(menuButton);
		
		resetButton.setBounds(135, 5, 100, 33);
		contentPane.add(resetButton);
		
		// THIS IS WHERE WE ADD THE LEVELVIEW
		currentLevelView.setBounds(50, 50, 900, 900);
		// currentLevelView.setBackground(Color.RED);
		contentPane.add(currentLevelView);

	}

	
	public void initControllers(){
		
		// Register the button controllers
		menuButton.addActionListener(new NavigateMainMenu(app));
		// resetButton.addActionListener(new resetLevelController());
	}
	
	public void setDraggedTile(TileView tv){
		this.draggedTile = tv;
	}
	
	public void setLevelView(LevelView lv){
		this.currentLevelView = lv;
	}
	
	public TileView getDraggedTile(){
		return this.draggedTile;
	}

	public LevelView getLevelView(){
		return this.currentLevelView;
	}

	public void updateCurrentLevelView() {
		
		Level currLev = m.getCurrentLevel();
		int currLevNum = currLev.getLevelNum();
		if(currLevNum == 1 || currLevNum == 4 || currLevNum == 7 || currLevNum == 10 || currLevNum == 13){
			currentLevelView = new PuzzleLevelView((PuzzleLevel)currLev);
		}
		else if(currLevNum == 2 || currLevNum == 5 || currLevNum == 6 || currLevNum == 11 || currLevNum == 14){
			currentLevelView = new LightningLevelView((LightningLevel)currLev);
		}
		else if(currLevNum == 3 || currLevNum == 6 || currLevNum == 9 || currLevNum == 12 || currLevNum == 15){
			currentLevelView = new ReleaseLevelView((ReleaseLevel)currLev);
		}
		
		contentPane.remove(2);
		currentLevelView.initView();
		contentPane.add(currentLevelView);
		
		System.out.println(1);
		
	}
	
	
}
