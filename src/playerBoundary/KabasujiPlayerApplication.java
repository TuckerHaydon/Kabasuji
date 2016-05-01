package playerBoundary;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
	
	public KabasujiPlayerApplication(GameModel m){
		this.m = m;
		init();
	}
	
	public KabasujiPlayerApplication(GameModel m, String levelPath, KabasujiBuilderApplication builderapp){
		this.m = m;
		init(levelPath, builderapp);
	}
	
	public void init(){
		initModel();
		initView();
		initControllers();
		
//		displaySplashScreen();
//		playThemeSong();

		displayMainMenu();
	}
	
	public void init(String levelPath, KabasujiBuilderApplication builderapp){
		initModel(levelPath);
		initView();
		initControllers();
		this.gameWindow.switchTobuilderTestMode(builderapp);
		
		m.selectCurrentAM(2);
		displayGameWindow();
	}
	
	public void initModel(){
		m.loadGame("src/resources/games/DefaultGame");
		m.setCurrentLevel(0);
		m.initModel();
	}
	
	void initModel(String levelPath){
		m.loadLevel(levelPath);
		m.setCurrentLevel(0);
		m.initModel();
	}
	
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
	
	public void initControllers(){
		gameWindow.initControllers();
		mainMenu.initControllers();
		levelSelectionMenu.initControllers();
		achievementsMenu.initControllers();
		instructionsPage.initControllers();
	}
	
	public void displayMainMenu(){
		mainMenu.setVisible(true);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
		instructionsPage.setVisible(false);
	}
	
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
	
	public void displayLevelSelectionMenu(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(true);
		achievementsMenu.setVisible(false);
		instructionsPage.setVisible(false);
		levelSelectionMenu.refreshView();
	}
	
	public void displayAchievementsMenu(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(true);
		instructionsPage.setVisible(false);
		achievementsMenu.updateView();
	}
	
	public void displayInstructionsPage(){
		mainMenu.setVisible(false);
		gameWindow.setVisible(false);
		levelSelectionMenu.setVisible(false);
		achievementsMenu.setVisible(false);
		instructionsPage.setVisible(true);
	}
	
	public GameWindow getGameWindow(){
		return gameWindow;

	}
	
	public AchievementsMenu getAchievementsMenu(){
		return this.achievementsMenu;
	}
	
	public InstructionsPage getInstructionsPage(){
		return this.instructionsPage;
	}
	
	public void repaintAll(){
		this.getGameWindow().getLevelView().getScrollPane().repaint();
		this.getGameWindow().getLevelView().getBoardView().repaint();
	}
	
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
	
	public GameModel getGameModel(){
		return m;
	}
}
