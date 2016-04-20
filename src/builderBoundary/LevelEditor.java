package builderBoundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import builderController.ExportLevelHandler;
import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;
import builderEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class LevelEditor extends JFrame implements KeyListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JButton exportGameButton, goToMenuButton;
	LevelBuilderView levelBuilderView;
	JPanel contentPane;

	
	public LevelEditor(KabasujiBuilderApplication app){
		super();
		
		this.app = app;
		m = new BuilderModel();

		
		levelBuilderView = new LevelBuilderView(m.getLevel(), app, m); 
		
		// Create all of the components
		exportGameButton = new JButton("Export");
		goToMenuButton = new JButton("Main Menu");

		
		// TODO implement all the other shit.
		
	}
	
	public void initView(){
		
		exportGameButton.setBackground(new Color(128, 128, 128));
		exportGameButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		goToMenuButton.setBackground(new Color(128, 128, 128));
		goToMenuButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		
		// Init sub components
		levelBuilderView.initView();
		
		// Set Frame properties
		setSize(1000, 1000);
		setTitle("Level Editor");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(255,228,225));
		contentPane.setLayout(null);
		
		// Add the buttons
		exportGameButton.setBounds(5, 5, 150, 33);
		contentPane.add(exportGameButton);
		
		goToMenuButton.setBounds(170, 5, 150, 33);
		contentPane.add(goToMenuButton);
		
		// Add the level view
		levelBuilderView.setBounds(50, 50, 900, 900);
		contentPane.add(levelBuilderView);

		
	}
	
	public void initControllers(){
		// TODO add all the controllers
		levelBuilderView.initControllers();
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
		exportGameButton.addActionListener(new ExportLevelHandler(m));
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode() == 'z'){
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public LevelBuilderView getLevelBuilderView(){
		return this.levelBuilderView;
	}
	

}
