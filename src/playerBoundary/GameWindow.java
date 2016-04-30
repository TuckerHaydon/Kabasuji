package playerBoundary;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import builderBoundary.KabasujiBuilderApplication;
import playerController.GameWindowNavigateMainMenu;
import playerController.ResetLevelController;
import playerController.TestLevelNavigateLevelEditorMove;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;

/**
 * 
 * @author tuckerhaydon
 *
 */
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
		
	}
	
	public void initView(){
		
		// Get the first level view
		updateCurrentLevelView();
		
		// Init sub components
		currentLevelView.initView();
		
		// Set Frame properties
		setSize(1000, 1000);
		setTitle("Game Window");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 228, 225));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Add the buttons
		menuButton.setBounds(5, 5, 100, 33);
		menuButton.setBackground(new Color(128, 128, 128));
		contentPane.add(menuButton);
		
		resetButton.setBounds(135, 5, 100, 33);
		resetButton.setBackground(new Color(128, 128, 128));
		contentPane.add(resetButton);
		
		// Add the level view
		currentLevelView.setBounds(50, 50, 900, 900);
		contentPane.add(currentLevelView);

	}

	
	public void initControllers(){
		
		// Register the button controllers
		menuButton.addActionListener(new GameWindowNavigateMainMenu(app,m));
		resetButton.addActionListener(new ResetLevelController(app,m));
		currentLevelView.initControllers();
		
	}
	
	public void setDraggedTile(TileView tv){
		this.draggedTile = tv;
		this.add(draggedTile, 0);
	}
	
	public void setLevelView(LevelView lv){
		this.currentLevelView = lv;
	}
	
	public TileView getDraggedTile(){
		return this.draggedTile;
	}
	
	public void releaseDraggedTile(){
		if(draggedTile == null) return;
		this.remove(draggedTile);
		draggedTile = null;
	}
	
	public LevelView getLevelView(){
		return this.currentLevelView;
	}

	void updateCurrentLevelView() {
		
		Level currLev = m.getCurrentLevel();
//		int currLevNum = currLev.getLevelNum();
		
		// Holy shit this is so bad. I feel so dirty. Don't change this though. Need this for the level tester
		try{
			currentLevelView = new PuzzleLevelView(app, m, (PuzzleLevel)currLev);
			return;
		}
		catch(Exception e){}
		
		try{
			currentLevelView = new LightningLevelView(app, m, (LightningLevel)currLev);
			return;
		}
		catch(Exception e){}
		
		try{
			currentLevelView = new ReleaseLevelView(app, m, (ReleaseLevel)currLev);
			return;
		}
		catch(Exception e){}
	}
	
	public void updateView() {
		
		// Remove the current level view
		contentPane.remove(currentLevelView);
		
		// Get the new level view
		updateCurrentLevelView();
		
		// Initialize it and set proper bounds
		currentLevelView.initView();
		
		// TODO fix this. Find where the controllers should be initialized. 
		currentLevelView.initControllers();
		currentLevelView.setBounds(50, 50, 900, 900);
		
		// Add the view back into the panel
		contentPane.add(currentLevelView);
	}
	
	public void displayDraggedTile(){
		
		if(draggedTile != null){
			draggedTile.setBounds(draggedTile.getX(), draggedTile.getY(), 6*draggedTile.getSquareWidth(), 6*draggedTile.getSquareWidth());
		}
	}
	
	public void switchTobuilderTestMode(KabasujiBuilderApplication builderapp){
		menuButton.setText("Back");
		//remove the default ActionListener
		menuButton.removeActionListener(menuButton.getActionListeners()[0]);
		menuButton.addActionListener(new TestLevelNavigateLevelEditorMove(app,builderapp));
		m.disableAchievement();
		resetButton.setVisible(false);
	}
	
	
}
