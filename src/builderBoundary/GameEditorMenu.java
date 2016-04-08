package builderBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameEditorMenu extends JFrame {
	
	KabasujiBuilderApplication app;
	
	JButton createGameButton;
	JButton editGameButton;
	JButton goToMenuButton;
	
	public GameEditorMenu(KabasujiBuilderApplication app){
		super();
		
		this.app = app;
		
		// Create the buttons
		createGameButton = new JButton();
		editGameButton = new JButton();
		goToMenuButton = new JButton();
	}
	
	public void initView(){
		
		// Set frame properties
		this.setSize(1000, 1000);
		this.setTitle("Game Editor Menu");
		
		// Set frame layout
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons
		this.add(createGameButton);
		this.add(editGameButton);
		this.add(goToMenuButton);
		
	}
	
	public void initControllers(){
		// TODO createGameController
		// TODO editGameController
		// TODO goToMenuController
	}

}
