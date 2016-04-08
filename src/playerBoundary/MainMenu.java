package playerBoundary;

import javax.swing.JButton;
import javax.swing.JFrame;

import application.PlayerLauncher;
import playerController.NavigateAchievementMenu;

public class MainMenu extends JFrame {
	
	JButton loadGame;
	JButton playGame;
	JButton viewAchievements;
	KabasujiPlayerApplication app;
	
	public MainMenu(KabasujiPlayerApplication app){
		super();
		this.setSize(1000,1000);
		this.setTitle("Main Menu");
		
		loadGame = new JButton("Load Game");
		playGame = new JButton("Play Game");
		viewAchievements = new JButton("View Achievements");
		this.app = app;
	}
	
	public void initView(){
		this.add(loadGame);
		this.add(playGame);
		this.add(viewAchievements);
	}
	
	public void initControllers(){
		viewAchievements.addActionListener(new NavigateAchievementMenu(app));
	}

}
