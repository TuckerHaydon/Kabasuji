package builderBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LevelEditorMenu extends JFrame {
	
	KabasujiBuilderApplication app;
	JButton createLevelButton;
	JButton editLevelButton;
	JButton goToMenuButton;
	
	public LevelEditorMenu(KabasujiBuilderApplication app){
		super();
		
		this.app = app;
		
		// Create the buttons
		createLevelButton = new JButton();
		editLevelButton = new JButton();
		goToMenuButton = new JButton();
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
		// TODO set the createLevel controller
		// TODO set the editLevel controller
	}

}
