package playerBoundary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import playerEntity.GameModel;

public class KabasujiPlayerApplication {
	
	GameWindow gameWindow;
	MainMenu mainMenu;
	LevelSelectionMenu levelSelectionMenu;
	AchievementsMenu achievementsMenu;
	GameModel m;
	
	public KabasujiPlayerApplication(){
		init();
	}

	
	public void init(){
		initModel();
		initView();
		initControllers();
	}
	
	public void initModel(){
		m = new GameModel();
		m.initModel();
	}
	
	public void initView(){
		
		// Create the various frames
		gameWindow = new GameWindow(this, m);
		mainMenu = new MainMenu(this);
		levelSelectionMenu = new LevelSelectionMenu(this, m);
		achievementsMenu = new AchievementsMenu(this, m);
		
		// Initialize all the views in the various frames
		gameWindow.initView();
		mainMenu.initView();
		levelSelectionMenu.initView();
		achievementsMenu.initView();
		
		// Slash screen stuff
		displaySplashScreen();
		
		// SHow the main menu
		displayMainMenu();
	}
	
	public void initControllers(){
		gameWindow.initControllers();
		mainMenu.initControllers();
		levelSelectionMenu.initControllers();
		achievementsMenu.initControllers();
	}
	
	public void displayMainMenu(){
		mainMenu.setVisible(true);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
	}
	
	public void displayGameWindow(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(true);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
	}
	
	public void displayLevelSelectionMenu(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(true);
		achievementsMenu.setVisible(false);
	}
	
	public void displayAchievementsMenu(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(true);
	}
	
	public GameWindow getGameWindow(){
		return gameWindow;

	}
	
	void displaySplashScreen(){
		JFrame splash = new JFrame("Splash Screen");
		splash.setBounds(200, 200, 200, 200);
		splash.getContentPane().add(new JLabel("Welcome!", SwingConstants.CENTER));
		
		splash.setVisible(true);
		long start = System.currentTimeMillis();
		while(System.currentTimeMillis() - start < 5000);
		splash.dispose();
	}
}
