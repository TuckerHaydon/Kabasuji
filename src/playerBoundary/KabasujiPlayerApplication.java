package playerBoundary;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import builderBoundary.KabasujiBuilderApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class KabasujiPlayerApplication {
	
	GameWindow gameWindow;
	MainMenu mainMenu;
	LevelSelectionMenu levelSelectionMenu;
	AchievementsMenu achievementsMenu;
	GameModel m;
	InstructionsPage instructionsPage;
	
	/**
	 * Constructor. Must take in a game model. Ensures that all applications have models
	 * @param m
	 */
	public KabasujiPlayerApplication(GameModel m){
		this.m = m;
		init();
	}
	
	/**
	 * Constructor used for testing. Takes in a file path to the level to be tested and a builder so that windows can be properly shown
	 * @param m GameModel
	 * @param levelPath Path to the level to be tested
	 * @param builderapp The builder applicaiton
	 */
	public KabasujiPlayerApplication(GameModel m, String levelPath, KabasujiBuilderApplication builderapp){
		this.m = m;
		init(levelPath, builderapp);
	}
	
	/**
	 * Initialized the application. Inits the model, view, and controllers. Displays the main menu.
	 */
	public void init(){
		initModel();
		initView();
		initControllers();
		
//		displaySplashScreen();
//		playThemeSong();

		displayMainMenu();
	}
	
	/**
	 * Initializes the application for testing. Takes in a path to the level to be tested and the builder application.
	 * @param levelPath - Path to the level to be tested
	 * @param builderapp - The builder application
	 */
	public void init(String levelPath, KabasujiBuilderApplication builderapp){
		initModel(levelPath);
		initView();
		initControllers();
		this.gameWindow.switchTobuilderTestMode(builderapp);
		
		m.selectCurrentAM(2);
		displayGameWindow();
	}
	
	/**
	 * Initializes the model. Sets the default game to be played and the current level to 0.
	 */
	public void initModel(){
		m.loadGame("src/resources/games/DefaultGame");
		m.setCurrentLevel(0);
		m.initModel();
	}
	
	/**
	 * Initializes the model for testing. Takes in a path to a level to be tested. Loads that specific level.
	 * @param levelPath
	 */
	void initModel(String levelPath){
		m.loadLevel(levelPath);
		m.setCurrentLevel(0);
		m.initModel();
	}
	
	/**
	 * Instructs all of the various frames to initialize their own views.
	 */
	public void initView(){
		
		// Create the various frames
		gameWindow = new GameWindow(this, m);
		mainMenu = new MainMenu(this, m);
		levelSelectionMenu = new LevelSelectionMenu(this, m);
		achievementsMenu = new AchievementsMenu(this, m);
		instructionsPage = new InstructionsPage(this, m);
		
		// Initialize all the views in the various frames
		gameWindow.initView();
		mainMenu.initView();
		levelSelectionMenu.initView();
		achievementsMenu.initView();
		instructionsPage.initView();
		
	}
	
	/**
	 * Instructs all of the individual frames to initialize their own controllers
	 */
	public void initControllers(){
		gameWindow.initControllers();
		mainMenu.initControllers();
		levelSelectionMenu.initControllers();
		achievementsMenu.initControllers();
		instructionsPage.initControllers();
	}
	
	/**
	 * Diaplays only the main menu
	 */
	public void displayMainMenu(){
		mainMenu.setVisible(true);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
		instructionsPage.setVisible(false);
	}
	
	/**
	 * Displays only the game window
	 */
	public void displayGameWindow(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(true);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
		instructionsPage.setVisible(false);
		
		// Bring to focus
		gameWindow.toFront();
		gameWindow.requestFocus();
	}
	
	/**
	 * Displays only the level selection menu
	 */
	public void displayLevelSelectionMenu(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(true);
		achievementsMenu.setVisible(false);
		instructionsPage.setVisible(false);
		levelSelectionMenu.refreshView();
	}
	
	/**
	 * Displays only the achievement menu
	 */
	public void displayAchievementsMenu(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(true);
		instructionsPage.setVisible(false);
		achievementsMenu.updateView();
	}
	
	/**
	 * Displays only the instructions page
	 */
	public void displayInstructionsPage(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
		instructionsPage.setVisible(true);
	}
	
	/**
	 * Returns the game window
	 * @return the game window
	 */
	public GameWindow getGameWindow(){
		return gameWindow;

	}
	
	/**
	 * Returns the achievements menu
	 * @return the achievements menu
	 */
	public AchievementsMenu getAchievementsMenu(){
		return this.achievementsMenu;
	}
	
	/**
	 * Returns the instructions page
	 * @return the instructions page
	 */
	public InstructionsPage getInstructionsPage(){
		return this.instructionsPage;
	}
	
	/**
	 * Instructs the board and scrollpane in the game window to repaint 
	 */
	public void repaintAll(){
		this.getGameWindow().getLevelView().getScrollPane().repaint();
		this.getGameWindow().getLevelView().getBoardView().repaint();
	}
	
	/**
	 * Displays the splash screen. Plays the intro song and pauses for 21 seconds.
	 */
	void displaySplashScreen(){
		
		Clip clip = null;
		try {
			File f = new File("src/resources/audio/intro.wav");
//			File f = new File("src/resources/audio/themesong.wav");
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(f));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame splash = new JFrame("Tucker,Dorothy,Kacper,Joey,Nidhi,Damani");
		splash.setBounds(200, 250, 505, 400);
		JLabel meow = new JLabel("");
		meow.setIcon(new ImageIcon("src/resources/pictures/RainbowBunchie.gif"));
//		splash.getContentPane().add(new JLabel("Welcome!\nAuthors: Tucker, Dorothy, Kacper, Nidhi, and Damani", SwingConstants.CENTER));
		JLabel reminder = new JLabel("Please turn up your volume.");
		reminder.setBounds(300, 0, 200, 100);
		splash.add(reminder, 0);
		splash.getContentPane().add(meow);
		
		splash.setVisible(true);
		long start = System.currentTimeMillis();
		while(System.currentTimeMillis() - start < 21000);
		
		try{
			clip.stop();
		}
		catch(Exception e){} // NOOP
		
		splash.dispose();
	}
	
	/**
	 * Plays the theme song
	 */
	void playThemeSong(){
		try {
			File f = new File("src/resources/audio/recorder.wav");
//			File f = new File("src/resources/audio/themesong.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(f));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the game model
	 * @return the game model for this application
	 */
	public GameModel getGameModel(){
		return m;
	}
}
