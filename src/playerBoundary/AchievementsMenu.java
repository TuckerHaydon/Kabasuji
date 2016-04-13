package playerBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import playerController.NavigateMainMenu;
import playerEntity.GameModel;

public class AchievementsMenu extends JFrame {
	
	KabasujiPlayerApplication app;
	GameModel m;
	
	JButton goToMenu;
	JButton resetAchievements;
	JLabel achievements[];
	
	public AchievementsMenu(KabasujiPlayerApplication app, GameModel m){
		super();
		this.m = m;
		this.app = app;
		
		// Create the buttons
		goToMenu = new JButton("Main Menu");
		resetAchievements = new JButton("Reset Achievements");
	}
	
	public void initView(){
		
		// Set the properties of the frame
		this.setSize(1000, 1000);
		this.setTitle("Achievements Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the layout of the frame
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons
		this.add(goToMenu);
		this.add(resetAchievements);
		
	}
	
	public void initControllers(){
		goToMenu.addActionListener(new NavigateMainMenu(app));
		// TODO reset achievements controller
	}

}
