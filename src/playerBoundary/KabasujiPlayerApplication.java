package playerBoundary;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
		playThemeSong();
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
		mainMenu = new MainMenu(this, m);
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
		achievementsMenu.updateView();
	}
	
	public GameWindow getGameWindow(){
		return gameWindow;

	}
	
	public GameModel getGameModel(){
		return m;
	}
	
	public AchievementsMenu getAchievementsMenu(){
		return this.achievementsMenu;
	}
	
	void displaySplashScreen(){
		JFrame splash = new JFrame("Splash Screen");
		splash.setBounds(200, 200, 400, 200);
		splash.getContentPane().add(new JLabel("Welcome!\nAuthors: Tucker, Dorothy, Kacper, Nidhi, and Damani", SwingConstants.CENTER));
		
		splash.setVisible(true);
		long start = System.currentTimeMillis();

		while(System.currentTimeMillis() - start < 3000);
		splash.dispose();
	}
	
	void playThemeSong(){
		try {
			File f = new File("src/resources/audio/rainbow_bunchie.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(f));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
