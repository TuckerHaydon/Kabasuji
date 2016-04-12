package playerBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import playerController.NavigateMainMenu;
import playerEntity.GameModel;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;

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


		// Initialize the buttons
		menuButton = new JButton("Main Menu");
		resetButton = new JButton("Reset Level");

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
