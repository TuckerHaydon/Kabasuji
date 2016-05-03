package builderBoundary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import builderEntity.BuilderModel;

/**
 * The top-level entry point for the Kabasuji Builder Application. Creates the various frames for each of the game editors and menus. 
 * Determines which frames to show and ensures that each of the fields is contructed with the proper parameters.
 * @author tuckerhaydon
 */
public class KabasujiBuilderApplication {
	
	MainMenu mainMenu;
	LevelEditorMenu levelEditorMenu;
	LevelEditor levelEditor;
	GameEditorMenu gameEditorMenu;
	GameEditor gameEditor;
	InstructionsPage instructionsPage;
	BuilderModel m;
	
	/**
	 * Constructor. Ensures that the BuilderModel is non-null 
	 * @param m The top-lvel BuilderModel
	 */
	public KabasujiBuilderApplication(BuilderModel m){
		if(m == null){
			throw new RuntimeException();
		}
		
		this.m = m;
	}
	
	/**
	 * Instructs each of the various frames to initialize their view and controller objects
	 */
	public void init(){
		initView();
		initControllers();
	}
	
	void initView(){
		
		// Create the various frames
		mainMenu = new MainMenu(this);
		levelEditorMenu = new LevelEditorMenu(this, m);
		levelEditor = new LevelEditor(this, m);
		gameEditorMenu = new GameEditorMenu(this, m);
		gameEditor = new GameEditor(this, m);
		instructionsPage = new InstructionsPage(this, m);
		
		// Have the frames create their various views
		mainMenu.initView();
		levelEditorMenu.initView();
		levelEditor.initView();
		gameEditorMenu.initView();
		gameEditor.initView();
		instructionsPage.initView();
		
		// Display the main menu
		displayMainMenu();
		
	}
	
	void initControllers(){
		mainMenu.initControllers();
		levelEditorMenu.initControllers();
		levelEditor.initControllers();
		gameEditorMenu.initControllers();
		gameEditor.initControllers();
		instructionsPage.initControllers();
	}
	
	/**
	 * Sets only the main menu frame to be visible
	 */
	public void displayMainMenu(){
		mainMenu.setVisible(true);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
		instructionsPage.setVisible(false);
	}
	
	/**
	 * Sets only the level editor menu to be visible
	 */
	public void displayLevelEditorMenu(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(true);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
		instructionsPage.setVisible(false);
	}
	
	/**
	 * Sets only the game editor menu to be visible
	 */
	public void displayGameEditorMenu(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(true);
		gameEditor.setVisible(false);
		instructionsPage.setVisible(false);
	}
	
	/**
	 * Sets only the level editor to be visible. Sets the levelEditor to be in focus to enable the keyListener.
	 */
	public void displayLevelEditor(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(true);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
		instructionsPage.setVisible(false);
		
		// Bring to focus
		levelEditor.toFront();
		levelEditor.requestFocus();
	}
	
	/**
	 * Sets only the game editor to be visible
	 */
	public void displayGameEditor(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(true);
		instructionsPage.setVisible(false);
	}
	
	/**
	 * Sets only the instructions page to be visible
	 */
	public void displayInstructionsPage(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
		instructionsPage.setVisible(true);
	}
	
	/**
	 * Creates and displays a splash screen for 3 seconds
	 */
	public void displaySplashScreen(){
		JFrame splash = new JFrame("Splash Screen");
		splash.setBounds(200, 200, 400, 200);
		splash.getContentPane().add(new JLabel("Welcome!\nAuthors: Tucker, Dorothy, Kacper, Nidhi, and Damani", SwingConstants.CENTER));
		
		splash.setVisible(true);
		long start = System.currentTimeMillis();

		while(System.currentTimeMillis() - start < 3000);
		splash.dispose();
	}
	
	/**
	 * Hides all of the frames.
	 */
	public void hideAll(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
	}
	
	/**
	 * Instructs the level editor to initialize a new LevelEditorView
	 */
	public void refreshLevelEditor(){
		this.levelEditor.refresh();
		this.levelEditor.repaintLevelEditor();
	}
	
	/**
	 * Instruct the level editor to repaint the current level editor view
	 */
	public void repaintLevelEditor(){
		this.levelEditor.repaintLevelEditor();
	}

	/**
	 * Returns the level editor
	 * @return LevelEditor The LevelEditor window
	 */
	public LevelEditor getLevelEditor(){
		return this.levelEditor;
	}
	
	/**
	 * Returns the level editor menu
	 * @return LevelEditorMenu The LevelEditorMenu window
	 */
	public LevelEditorMenu getLevelEditorMenu(){
		return this.levelEditorMenu;
	}
	
	/**
	 * Returns the GameEditor
	 * @return GameEditor The GameEditor window
	 */
	public GameEditor getGameEditor(){
		return this.gameEditor;
	}
	
	/**
	 * Returns the GameEditorMenu
	 * @return GameEditorMenu The GameEditorMenu window
	 */
	public GameEditorMenu getGameEditorMenu(){
		return this.gameEditorMenu;
	}
	
	/**
	 * Returns the MainMenu
	 * @return MainMenu The MainMenu window
	 */
	public MainMenu getMainMenu(){
		return this.mainMenu;
	}

}
