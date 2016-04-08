package playerBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import playerController.NavigateMainMenu;

public class LevelSelectionMenu extends JFrame {
	
	JButton levels[];
	JButton goToMainMenu;
	KabasujiPlayerApplication app;
	
	public LevelSelectionMenu(KabasujiPlayerApplication app){
		super();
		this.app = app;
		
		goToMainMenu = new JButton("Main Menu");
	}
	
	public void initView(){
		
		// Set properties of the frame
		this.setSize(1000,1000);
		this.setTitle("Level Selection Menu");
		
		// Set the layout of the frame
		getContentPane().setLayout(new GridLayout(3,1));

		// Add the buttons
		this.add(goToMainMenu);
	}
	
	public void initControllers(){
		goToMainMenu.addActionListener(new NavigateMainMenu(app));
		// TODO level button controllers
	}

}
