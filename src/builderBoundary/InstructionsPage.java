package builderBoundary;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;

 
/**
 * This class is used to display the instruction of the game 
 * @author tuckerhaydon
 */
public class InstructionsPage extends JFrame {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JButton mainMenu;
	
	/**
	 * Constructor for instructions page
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 */
	public InstructionsPage(KabasujiBuilderApplication app, BuilderModel m){
		super();
		this.app = app;
		this.m = m;
		
		mainMenu = new JButton("Main Menu");
	}
	
	/**
	 * Initialize the instructions page window
	 */
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
		
		JLabel welcome= new JLabel("Welcome to Kabasuji =^^=");
		welcome.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(welcome);
		
		JLabel torotate= new JLabel("To add a tile to the bullpen:");
		torotate.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(torotate);
		
		JLabel holdcontrol= new JLabel("    Simply left-click a tile in the tile bank on the right");
		holdcontrol.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(holdcontrol);
		
		JLabel tomirror= new JLabel("To remove a tile from the bullpen:");
		tomirror.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(tomirror);
		
		JLabel holdshift= new JLabel("    Simply left-click a tile in the bullpen that you want to remove");
		holdshift.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(holdshift);
		
		JLabel undo= new JLabel("To undo a move, press control-z");
		undo.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(undo);
		
		JLabel redo= new JLabel("To redo a move, press shift-control-z");
		redo.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(redo);
		
		JLabel buildLevel= new JLabel("To build a level, click on create/edit a level. Editting is straightforward.");
		buildLevel.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(buildLevel);
		
		JLabel exportLevel= new JLabel("When the level is complete, click the export button to save it.");
		exportLevel.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(exportLevel);
		
		JLabel buildGame= new JLabel("To build a level, click on create/edit a game. Add levels to the game w/ buttons.");
		buildGame.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(buildGame);
		
		JLabel exportGame= new JLabel("When a game is complete, click the export button to save it");
		exportGame.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(exportGame);
		
		JLabel playGame= new JLabel("It can now be loaded and played by the player");
		playGame.setFont(new Font("Consolas", Font.PLAIN, 16));
		instructions.add(playGame);
		
		
		for(int i = 0; i < instructions.size(); i++){
			instructions.get(i).setBounds(100, 60+60*i, 800, 100);
			this.add(instructions.get(i));
		}
		
		mainMenu.setBounds(12, 13, 190, 47);
		mainMenu.setBackground(new Color(128, 128, 128));
		mainMenu.setFont(new Font("Snap ITC", Font.PLAIN, 16));
		this.add(mainMenu);
		
	}
	
	/**
	 * initialize the controller to get back to the main menu
	 */
	public void initControllers(){
		mainMenu.addActionListener(new NavigateMainMenu(app));
	}

}
