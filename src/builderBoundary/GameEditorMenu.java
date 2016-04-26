package builderBoundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderController.CreateGameHandler;
import builderController.EditGameHandler;
import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;

/**
 * The window for the GameEditor's menu. Contains buttons that allow the user to either create or edit a game and return to the main menu.
 * @author tuckerhaydon
 * @author jwilder
 */
public class GameEditorMenu extends JFrame {
	
	KabasujiBuilderApplication app;
	BuilderModel m; 
	
	JButton createGameButton;
	JButton editGameButton;
	JButton goToMenuButton;
	
	/**
	 * Constructor for the GameEditorMenu.Ensures that the parameters are non-null.
	 * @param app The top-level KabasujiBuilderApplication
	 * @param m The tip-levle BuilderModel
	 */
	public GameEditorMenu(KabasujiBuilderApplication app, BuilderModel m){
		super();
		
		if(app == null || m == null){
			throw new RuntimeException();
		}
		
		this.m = m;
		this.app = app;
		
		// Create the buttons
		createGameButton = new JButton("Create Game");
		editGameButton = new JButton("Edit Game");
		goToMenuButton = new JButton("Main Menu");
		
		
	}
	
	/**
	 * Initializes the various properties of the window. Adds the buttons to the menu
	 */
	public void initView(){
		this.setResizable(false);
		// Set frame properties
		this.setSize(1000, 1000);
		this.setTitle("Game Editor Menu");
		getContentPane().setBackground(new Color(255,228,225));
		// Set frame layout
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons
		createGameButton.setBackground(new Color(128, 128, 128));
		createGameButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		editGameButton.setBackground(new Color(128, 128, 128));
		editGameButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		goToMenuButton.setBackground(new Color(128, 128, 128));
		goToMenuButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		this.add(createGameButton);
		this.add(editGameButton);
		this.add(goToMenuButton);
		
	}
	
	/**
	 * Initializes the controllers for each of the buttons in the menu
	 */
	public void initControllers(){
		createGameButton.addActionListener(new CreateGameHandler(app, m));
		editGameButton.addActionListener(new EditGameHandler(app, m));
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
	}

}
