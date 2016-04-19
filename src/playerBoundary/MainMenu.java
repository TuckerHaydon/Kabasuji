package playerBoundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import playerController.LoadGame;
import playerController.NavigateAchievementMenu;
import playerController.NavigateLevelSelectionMenu;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class MainMenu extends JFrame {
	
	JButton loadGame;
	JButton playGame;
	JButton viewAchievements;
	KabasujiPlayerApplication app;
	GameModel m;
	
	public MainMenu(KabasujiPlayerApplication app, GameModel m){
		super();
		this.app = app;
		this.m = m;
		
		loadGame = new JButton("Load Game");
		playGame = new JButton("Play Game");
		viewAchievements = new JButton("View Achievements");
		
	}
	
	public void initView(){
		
		// Set properties of the frame
		this.setSize(1000,1000);
		this.setTitle("Main Menu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the layout
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons to the frame

		loadGame.setBackground(new Color(128, 128, 128));
		loadGame.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		playGame.setBackground(new Color(128, 128, 128));
		playGame.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		viewAchievements.setBackground(new Color(128, 128, 128));
		viewAchievements.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));this.add(loadGame);
		this.add(loadGame);
		this.add(playGame);
		this.add(viewAchievements);
	}
	
	public void initControllers(){
		viewAchievements.addActionListener(new NavigateAchievementMenu(app));
		playGame.addActionListener(new NavigateLevelSelectionMenu(app));
		loadGame.addActionListener(new LoadGame(m, app));
		// TODO add a loadGame controller
	}

}
