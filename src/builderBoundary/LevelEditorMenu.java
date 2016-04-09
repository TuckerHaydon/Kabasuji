package builderBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderController.CreateLevelHandler;
import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;

public class LevelEditorMenu extends JFrame {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JButton createLevelButton;
	JButton editLevelButton;
	JButton goToMenuButton;
	
	public LevelEditorMenu(KabasujiBuilderApplication app, BuilderModel m){
		super();
		
		this.app = app;
		this.m = m;
		
		// Create the buttons
		createLevelButton = new JButton("Create Level");
		editLevelButton = new JButton("Edit Level");
		goToMenuButton = new JButton("Main Menu");
	}
	
	public void initView(){
		
		// Set frame properties
		this.setSize(1000, 1000);
		this.setTitle("Level Editor Menu");
		
		// Set layout
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons
		this.add(createLevelButton);
		this.add(editLevelButton);
		this.add(goToMenuButton);
	}
	
	public void initControllers(){
		createLevelButton.addActionListener(new CreateLevelHandler(app, m));
		// TODO set the editLevel controller
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
	}

}
