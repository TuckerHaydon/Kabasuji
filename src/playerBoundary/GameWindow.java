package playerBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

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
	
	public GameWindow(KabasujiPlayerApplication app, GameModel m)
	{
		super();
		this.app = app;
		this.m = m;
		getContentPane().setLayout(new GridLayout(3,1));

		// Initialize the buttons
		menuButton = new JButton("Main Menu");
		resetButton = new JButton("Reset Level");
		
		//initialize the levelView
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

		
		// Set Frame properties
		this.setSize(1000, 1000);
		this.setTitle("Game Window");
		
		// Add the components
		this.add(menuButton);
		this.add(resetButton);

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
	
	
}
