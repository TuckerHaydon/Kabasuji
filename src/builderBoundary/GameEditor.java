package builderBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderController.NavigateMainMenu;

public class GameEditor extends JFrame {
	
	KabasujiBuilderApplication app;
	JButton levelButtons[];
	JButton exportGameButton;
	JButton goToMenuButton;
	
	
	public GameEditor(KabasujiBuilderApplication app){
		super();
		
		this.app = app;
		
		// Create the buttons
		exportGameButton = new JButton("Export Game");
		goToMenuButton = new JButton("Main Menu");
		// TODO create the level buttons
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
		// TODO add all of the level buttons
	}
	
	public void initControllers(){
		// TODO exportGame controller
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
		// TODO level button controllers
	}

}
