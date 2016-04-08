package playerBoundary;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends JFrame {
	
	JButton loadGame;
	JButton playGame;
	JButton viewAchievements;
	
	public MainMenu(){
		super();
		this.setSize(1000,1000);
		this.setTitle("Main Menu");
		
		loadGame = new JButton("Load Game");
		playGame = new JButton("Play Game");
		viewAchievements = new JButton("View Achievements");
	}
	
	public void initView(){
		this.add(loadGame);
		this.add(playGame);
		this.add(viewAchievements);
	}
	
	public void initControllers(){
		
	}

}
