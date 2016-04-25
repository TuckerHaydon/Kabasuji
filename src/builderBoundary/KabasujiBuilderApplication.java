package builderBoundary;

import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import builderController.Move;
import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 *
 */
public class KabasujiBuilderApplication {
	
	MainMenu mainMenu;
	LevelEditorMenu levelEditorMenu;
	LevelEditor levelEditor;
	GameEditorMenu gameEditorMenu;
	GameEditor gameEditor;
	BuilderModel m;
	java.util.Stack<Move> moves = new java.util.Stack<Move>();
	
	public KabasujiBuilderApplication(BuilderModel m){
		this.m = m;
	}
	
	public void init(){
		initModel();
		initView();
		initControllers();
	}
	
	public void initModel(){
	
	}
	
	public void initView(){
		
		// Create the various frames
		mainMenu = new MainMenu(this);
		levelEditorMenu = new LevelEditorMenu(this, m);
		levelEditor = new LevelEditor(this, m);
		gameEditorMenu = new GameEditorMenu(this, m);
		gameEditor = new GameEditor(this, m);
		
		// Have the frames create their various views
		mainMenu.initView();
		levelEditorMenu.initView();
		levelEditor.initView();
		gameEditorMenu.initView();
		gameEditor.initView();
		
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
	
	public void displaySplashScreen(){
		JFrame splash = new JFrame("Splash Screen");
		splash.setBounds(200, 200, 400, 200);
		splash.getContentPane().add(new JLabel("Welcome!\nAuthors: Tucker, Dorothy, Kacper, Nidhi, and Damani", SwingConstants.CENTER));
		
		splash.setVisible(true);
		long start = System.currentTimeMillis();

		while(System.currentTimeMillis() - start < 3000);
		splash.dispose();
	}
	
	public void hideAll(){
		mainMenu.setVisible(false);
		levelEditorMenu.setVisible(false);
		levelEditor.setVisible(false);
		gameEditorMenu.setVisible(false);
		gameEditor.setVisible(false);
	}
	
	public void refreshLevelEditor(){
		this.levelEditor.refresh();
	}

	public LevelEditor getLevelEditor(){
		return this.levelEditor;
	}
	public LevelEditorMenu getLevelEditorMenu(){
		return this.levelEditorMenu;
	}
	
	public GameEditor getGameEditor(){
		return this.gameEditor;
	}
	
	public GameEditorMenu getGameEditorMenu(){
		return this.gameEditorMenu;
	}
	
	public MainMenu getMainMenu(){
		return this.mainMenu;
	}

	public Enumeration<Move> getMoves() {
		return moves.elements();
	}
	
	public Move popMove() {
		return this.moves.pop();
	}
	
	public Move pushMove(Move m) {
		return this.moves.push(m);
	}
	
	public boolean undoMove() {
		Move m = popMove();
		
		if(m == null) {
			return false;
		}
		
		boolean stat = m.undoMove();
		if(stat) {
			refreshLevelEditor();
		} else{
			pushMove(m);
		}
		
		return stat;
	}
}
