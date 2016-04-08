package builderBoundary;

public class KabasujiBuilderApplication {
	
	MainMenu mainMenu;
	LevelEditorMenu levelEditorMenu;
	LevelEditor levelEditor;
	GameEditorMenu gameEditorMenu;
	GameEditor gameEditor;
	
	public KabasujiBuilderApplication(){
		
	}
	
	public void init(){
		
	}
	
	public void initModel(){
		
	}
	
	public void initView(){
		mainMenu.initView();
		levelEditorMenu.initView();
		levelEditor.initView();
		gameEditorMenu.initView();
		gameEditor.initView();
	}
	
	public void initConrollers(){
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

}
