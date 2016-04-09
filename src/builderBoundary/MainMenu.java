package builderBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderController.NavigateGameEditorMenu;
import builderController.NavigateLevelEditorMenu;

public class MainMenu extends JFrame {
	
	KabasujiBuilderApplication app;
	JButton levelEditorButton;
	JButton gameEditorButton;
	
	public MainMenu(KabasujiBuilderApplication app){
		super();
		this.app = app;
		
		// Create the buttons
		levelEditorButton = new JButton("Edit Level");
		gameEditorButton = new JButton("Edit Game");
	}
	
	public void initView(){
		
		// Set frame properties
		this.setSize(1000, 1000);
		this.setTitle("Main Menu");
		
		// Set the layout
		getContentPane().setLayout(new GridLayout(2,1));
		
		// Add the buttons
		this.add(levelEditorButton);
		this.add(gameEditorButton);
		
	}
	
	public void initControllers(){
		levelEditorButton.addActionListener(new NavigateLevelEditorMenu(app));
		gameEditorButton.addActionListener(new NavigateGameEditorMenu(app));
	}

}
