package playerBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import application.PlayerLauncher;
import playerController.NavigateAchievementMenu;
import playerController.NavigateLevelSelectionMenu;

public class MainMenu extends JFrame {
	
	JButton loadGame;
	JButton playGame;
	JButton viewAchievements;
	KabasujiPlayerApplication app;
	
	public MainMenu(KabasujiPlayerApplication app){
		super();
		this.app = app;
		
		loadGame = new JButton("Load Game");
		playGame = new JButton("Play Game");
		viewAchievements = new JButton("View Achievements");
		
	}
	
	public void initView(){
		
		// Set properties of the frame
		this.setSize(1000,1000);
		this.setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the layout
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons to the frame
		this.add(loadGame);
		this.add(playGame);
		this.add(viewAchievements);
	}
	
	public void initControllers(){
		viewAchievements.addActionListener(new NavigateAchievementMenu(app));
		playGame.addActionListener(new NavigateLevelSelectionMenu(app));
		// TODO add a loadGame controller
	}

}
