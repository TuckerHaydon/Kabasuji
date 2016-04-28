package playerBoundary;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import playerController.NavigateMainMenu;
import playerEntity.GameModel;
 

public class InstructionsPage extends JFrame {
	
	KabasujiPlayerApplication app;
	GameModel m;
	JButton mainMenu;
	
	public InstructionsPage(KabasujiPlayerApplication app, GameModel m){
		super();
		this.app = app;
		this.m = m;
		
		
		mainMenu = new JButton("Main Menu");
	}
	
	public void initView(){
		
		this.setLayout(null);
		setResizable(false);
		// Set properties of the frame
		this.setSize(1000,1000);
		
		ArrayList<JLabel> instructions = new ArrayList<>();
		
		instructions.add(new JLabel("Hello Friend!"));
		instructions.add(new JLabel("Welcome to Kabasuji"));
		instructions.add(new JLabel("To rotate a tile, hold control and either right-click or left-click on a tile in the bullpen."));
		
		
		
		for(int i = 0; i < instructions.size(); i++){
			instructions.get(i).setBounds(100, 100+100*i, 800, 100);
			this.add(instructions.get(i));
		}
		
		mainMenu.setBounds(0, 0, 200, 100);
		this.add(mainMenu);
		
	}
	
	public void initControllers(){
		mainMenu.addActionListener(new NavigateMainMenu(app, m));
	}

}
