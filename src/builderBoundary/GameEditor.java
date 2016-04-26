package builderBoundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderController.AddLevelToGameHandler;
import builderController.ExportGameHandler;
import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;
import builderEntity.Level;

/**
 * A Window that for the game editor. Contains an export game button, menu navigation button, and 15 buttons corresponding to each of the 15 levels in a game.
 * @author tuckerhaydon
 * @author jwilder
 */
public class GameEditor extends JFrame {
	
	KabasujiBuilderApplication app;
	JButton levelButtons[];
	JButton exportGameButton;
	JButton goToMenuButton;
	BuilderModel m;
	
	/**
	 * Constructor for the GameEditor. Initializes the various buttons and ensures that the parameters are non-null.
	 * @param app The top-level KabasujiBuilderApplication
	 * @param m The top-level BuilderModel
	 */
	public GameEditor(KabasujiBuilderApplication app, BuilderModel m){
		super();
		
		if(app == null || m == null){
			throw new RuntimeException();
		}
		
		this.app = app;
		this.m = m;
		
		// Create the buttons
		exportGameButton = new JButton("Export Game");
		goToMenuButton = new JButton("Main Menu");
		levelButtons = new JButton[15];
		
		// Create the 15 level buttons

		for(int i = 0; i < 15; i++){
			levelButtons[i] = new JButton("Level " + (i+1));
		}
		
		
		for(int i = 0; i < 15; i++){
			
		}
	}
	
	/**
	 * Sets the various properties of the frame and adds the buttons into the window.
	 */
	public void initView(){
		
		// Set the properties of the frame
		this.setSize(1000, 1000);
		this.setTitle("Game Editor");
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(255, 228, 225));
		// Set the layout
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons
		
		for(int i = 0; i < 15; i++){
			
			levelButtons[i].setBackground(new Color(128, 128, 128));
			levelButtons[i].setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		}
		exportGameButton.setBackground(new Color(128, 128, 128));
		exportGameButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		goToMenuButton.setBackground(new Color(128, 128, 128));
		goToMenuButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		this.add(exportGameButton);
		this.add(goToMenuButton);
		for(JButton b:levelButtons){
			this.add(b);
		}
			
	}
	
	/**
	 * Initializes the controllers for all of the buttons in the window.
	 */
	public void initControllers(){
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
		exportGameButton.addActionListener(new ExportGameHandler(app, m));
		
		for(int i = 0; i < levelButtons.length; i++){
			levelButtons[i].addActionListener(new AddLevelToGameHandler(app, m, i));
		}
	}
	
	
	public JButton[] getButtons(){
		return this.levelButtons;
	}
	public void refreshLevelButtons(){
		Level[] currLevs = m.getGame().getLevels();
		for(int i = 0; i < 15; i++){
			if(currLevs[i] == null){
				this.remove(levelButtons[i]);
				levelButtons[i] = new JButton("Level" + (i+1));
				levelButtons[i].setBackground(Color.RED);
				levelButtons[i].setOpaque(true);
				levelButtons[i].setBorderPainted(false);
				levelButtons[i].setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
				this.add(levelButtons[i]);
				levelButtons[i].addActionListener(new AddLevelToGameHandler(app, m, i));
			}
		}
	}
	
}
