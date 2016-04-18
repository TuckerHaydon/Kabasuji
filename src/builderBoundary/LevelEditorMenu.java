package builderBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import com.sun.prism.paint.Color;

import builderController.CreateLevelHandler;
import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;

public class LevelEditorMenu extends JFrame {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	public JButton createLevelButton;
	JButton editLevelButton;
	JButton goToMenuButton;
	
	public LevelEditorMenu(KabasujiBuilderApplication app, BuilderModel m){
		super();
		
		this.app = app;
		this.m = m;
		
	
	}
	
	public void initView(){
		
		// Set frame properties
		this.setSize(1000, 1000);
		this.setTitle("Level Editor Menu");
		
		// Set layout
		setLayout(null);
		// Create the buttons
		createLevelButton = new JButton("Create Level");
		editLevelButton = new JButton("Edit Level");
		goToMenuButton = new JButton("Main Menu");
		// Add the buttons
		createLevelButton.setBounds(375, 50, 250, 150);
		//createLevelButton.setBackground();
		editLevelButton.setBounds(375, 400, 250, 150);
		goToMenuButton.setBounds(375, 775, 250, 150);
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
