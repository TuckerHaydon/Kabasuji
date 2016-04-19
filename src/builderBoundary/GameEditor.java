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

/**
 * 
 * @author tuckerhaydon
 *
 */
public class GameEditor extends JFrame {
	
	KabasujiBuilderApplication app;
	JButton levelButtons[];
	JButton exportGameButton;
	JButton goToMenuButton;
	BuilderModel m;
	
	public GameEditor(KabasujiBuilderApplication app, BuilderModel m){
		super();
		
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
	}
	
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
	
	public void initControllers(){
		// TODO exportGame controller
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
		exportGameButton.addActionListener(new ExportGameHandler(m));
		
		for(int i = 0; i < levelButtons.length; i++){
			levelButtons[i].addActionListener(new AddLevelToGameHandler(m, i));
		}
	}

}
