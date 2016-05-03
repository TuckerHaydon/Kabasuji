package builderBoundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderController.NavigateGameEditorMenu;
import builderController.NavigateInstructionsPage;
import builderController.NavigateLevelEditorMenu;

/**
 * The window for the main builder menu. Contains a level editor button and a game editor button.
 * @author tuckerhaydon
 *
 */
public class MainMenu extends JFrame {
	
	KabasujiBuilderApplication app;
	JButton levelEditorButton;
	JButton gameEditorButton;
	JButton instructionsButton;
	
	/**
	 * Constructor for main menu. 	
	 * @param app - top level Kabasuji builder application
	 */
	public MainMenu(KabasujiBuilderApplication app){
		super();
		this.app = app;
		
		// Create the buttons
		levelEditorButton = new JButton("Create or Edit a Level");
		gameEditorButton = new JButton("Create or Edit a Game");
		instructionsButton = new JButton("Instructions");

	}
	
	/**
	 * Initializes main menu. Adds in all of the buttons and other window features.
	 */
	public void initView(){
		
		// Set frame properties
		this.setSize(1000, 1000);
		this.setTitle("Main Menu");
		
		// Set the layout
		getContentPane().setLayout(new GridLayout(3,1));
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(255, 228, 225));
		
		levelEditorButton.setBackground(new Color(128, 128, 128));
		levelEditorButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		gameEditorButton.setBackground(new Color(128, 128, 128));
		gameEditorButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		instructionsButton.setBackground(new Color(128, 128, 128));
		instructionsButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 26));
		
		// Add the buttons
		this.add(levelEditorButton);
		this.add(gameEditorButton);
		this.add(instructionsButton);
		
	}
	
	/**
	 * Registers controllers to main menu buttons.
	 */	
	public void initControllers(){
		levelEditorButton.addActionListener(new NavigateLevelEditorMenu(app));
		gameEditorButton.addActionListener(new NavigateGameEditorMenu(app));
		instructionsButton.addActionListener(new NavigateInstructionsPage(app));
	}

}
