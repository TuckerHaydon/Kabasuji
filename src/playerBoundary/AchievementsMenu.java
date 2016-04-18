package playerBoundary;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import playerController.NavigateMainMenu;
import playerController.ResetAchievementController;
import playerEntity.GameModel;

public class AchievementsMenu extends JFrame {
	KabasujiPlayerApplication app;
	GameModel m;
	JButton goToMenu;
	JButton resetAchievements;
	JLabel achievements[];
	AchievementPanel panel;
	
	public AchievementsMenu(KabasujiPlayerApplication app, GameModel m){
		super();
		this.m = m;
		this.app = app;
		// Create the buttons
		panel = new AchievementPanel(m.getAchievements());
		goToMenu = panel.getMainMenuButton();
		resetAchievements = panel.getResetAchievementButton();
	}
	
	public void initView(){
		
		// Set the properties of the frame
		this.setSize(1000, 1000);
		this.setTitle("Achievements Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(panel);
		
		
	}
	
	public void initControllers(){
		goToMenu.addActionListener(new NavigateMainMenu(app,m));
		this.resetAchievements.addActionListener(new ResetAchievementController(app,m));
	}
	
	public void updateView(){
		this.panel.redraw();
	}
}
