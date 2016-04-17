package builderBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderController.AddLevelToGameHandler;
import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;

public class GameEditor extends JFrame {
	
	KabasujiBuilderApplication app;
	JButton levelButtons[];
	JButton exportGameButton;
	JButton goToMenuButton;
	BuilderModel m;
	
	public GameEditor(KabasujiBuilderApplication app, BuilderModel m){
		super();
		
		this.app = app;
		this.m = m;
		
		// Create the buttons
		exportGameButton = new JButton("Export Game");
		goToMenuButton = new JButton("Main Menu");
		levelButtons = new JButton[15];
		
		// Create the 15 level buttons
		for(int i = 0; i < 15; i++){
			levelButtons[i] = new JButton("Level " + (i+1));
		}
	}
	
	public void initView(){
		
		// Set the properties of the frame
		this.setSize(1000, 1000);
		this.setTitle("Game Editor");
		
		// Set the layout
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons
		this.add(exportGameButton);
		this.add(goToMenuButton);
		for(JButton b:levelButtons){
			this.add(b);
		}
			
	}
	
	public void initControllers(){
		// TODO exportGame controller
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
		
		for(int i = 0; i < levelButtons.length; i++){
			levelButtons[i].addActionListener(new AddLevelToGameHandler(m, i));
		}
	}

}
