package builderBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import builderController.CreateGameHandler;
import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;

public class GameEditorMenu extends JFrame {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	JButton createGameButton;
	JButton editGameButton;
	JButton goToMenuButton;
	
	public GameEditorMenu(KabasujiBuilderApplication app, BuilderModel m){
		super();
		
		this.m = m;
		this.app = app;
		
		// Create the buttons
		createGameButton = new JButton("Create Game");
		editGameButton = new JButton("Edit Game");
		goToMenuButton = new JButton("Main Menu");
		
		
	}
	
	public void initView(){
		setResizable(false);
		// Set frame properties
		this.setSize(1000, 1000);
		this.setTitle("Game Editor Menu");
		
		// Set frame layout
		getContentPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons
		this.add(createGameButton);
		this.add(editGameButton);
		this.add(goToMenuButton);
		
	}
	
	public void initControllers(){
		createGameButton.addActionListener(new CreateGameHandler(app, m));
		// TODO editGameController
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
	}

}
