package playerBoundary;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import playerController.NavigateMainMenu;
import playerEntity.GameModel;
 
/**
 * This class is used to display the instruction of the game 
 * @author tuckerhaydon
 */
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
		
		this.getContentPane().setBackground(new Color(255, 228, 225));
		
		ArrayList<JLabel> instructions = new ArrayList<>();
		
		
		
		JLabel hellofriend= new JLabel("Hello Friend!");
		hellofriend.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(hellofriend);
		
		JLabel welcome= new JLabel("Welcome to Kabasuji =^¦Ø^=");
		welcome.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(welcome);
		
		JLabel torotate= new JLabel("To rotate a tile:");
		torotate.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(torotate);
		
		JLabel holdcontrol= new JLabel("    Hold control and either right-click or left-click on a tile in the bullpen.");
		holdcontrol.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(holdcontrol);
		
		JLabel tomirror= new JLabel("To mirror a tile:");
		tomirror.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(tomirror);
		
		JLabel holdshift= new JLabel("    Hold shift and either right-click or left-click on a tile in the bullpen.");
		holdshift.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(holdshift);
		
		
		for(int i = 0; i < instructions.size(); i++){
			instructions.get(i).setBounds(100, 100+100*i, 800, 100);
			this.add(instructions.get(i));
		}
		
		mainMenu.setBounds(12, 13, 190, 47);
		mainMenu.setBackground(new Color(128, 128, 128));
		mainMenu.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		this.add(mainMenu);
		
	}
	
	public void initControllers(){
		mainMenu.addActionListener(new NavigateMainMenu(app, m));
	}

}
