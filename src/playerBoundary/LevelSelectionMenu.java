package playerBoundary;

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
		this.setSize(1000,1000);
		this.setTitle("Level Selection Menu");
		
		goToMainMenu = new JButton("Main Menu");
	}
	
	public void initView(){
		this.add(goToMainMenu);
	}
	
	public void initControllers(){
		goToMainMenu.addActionListener(new NavigateMainMenu(app));
	}

}
