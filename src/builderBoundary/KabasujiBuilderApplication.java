package builderBoundary;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import builderEntity.BuilderModel;

public class KabasujiBuilderApplication {
	
	MainMenu mainMenu;
	LevelEditorMenu levelEditorMenu;
	LevelEditor levelEditor;
	GameEditorMenu gameEditorMenu;
	GameEditor gameEditor;
	
	BuilderModel m;
	
	public KabasujiBuilderApplication(){
		
	}
	
	public void init(){
		initModel();
		initView();
		initControllers();
	}
	
	public void initModel(){
		m = new BuilderModel();	
	}
	
	public void initView(){
		
		// Create the various frames
		mainMenu = new MainMenu(this);
		levelEditorMenu = new LevelEditorMenu(this, m);
		levelEditor = new LevelEditor(this);
		gameEditorMenu = new GameEditorMenu(this, m);
		gameEditor = new GameEditor(this);
		
		// Have the frames create their various views
		mainMenu.initView();
		levelEditorMenu.initView();
		levelEditor.initView();
		gameEditorMenu.initView();
		gameEditor.initView();
		
		// Display Splash screen
		displaySplashScreen();
		
		// Display the main menu
		displayMainMenu();
	}
	
	public void initControllers(){
		mainMenu.initControllers();
		levelEditorMenu.initControllers();
		levelEditor.initControllers();
		gameEditorMenu.initControllers();
		gameEditor.initControllers();
	}
	
	public void displayMainMenu(){
		mainMenu.setVisible(true);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
	}
	
	public void displayLevelEditorMenu(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(true);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
	}
	
	public void displayGameEditorMenu(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(true);
		gameEditor.setVisible(false);
	}
	
	public void displayLevelEditor(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(true);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
	}
	
	public void displayGameEditor(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(true);
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

}
