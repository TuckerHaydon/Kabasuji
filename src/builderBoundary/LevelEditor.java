package builderBoundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EmptyStackException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import builderController.ExportLevelHandler;
import builderController.TestLevelHandler;
import builderController.UndoManager;
import builderController.NavigateMainMenu;
import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class LevelEditor extends JFrame implements KeyListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JButton exportGameButton, goToMenuButton,testLevelButton;
	LevelBuilderView levelBuilderView;
	JPanel contentPane;	
	boolean isControlPressed = false;
	
	public LevelEditor(KabasujiBuilderApplication app, BuilderModel m){
		super();
		this.setFocusable(true);
		this.addKeyListener(this);
		this.app = app;
		this.m = m;
		
		levelBuilderView = new LevelBuilderView(this.m.getLevel(), this.app, this.m); 
		
		// Create all of the components
		exportGameButton = new JButton("Export");
		goToMenuButton = new JButton("Main Menu");
		testLevelButton = new JButton("Test Level");
		
		// TODO implement all the other shit.
		
	}
	
	public void initView(){
		
		exportGameButton.setBackground(new Color(128, 128, 128));
		exportGameButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		goToMenuButton.setBackground(new Color(128, 128, 128));
		goToMenuButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		testLevelButton.setBackground(new Color(128, 128, 128));
		testLevelButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		
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
		
		testLevelButton.setBounds(335, 5, 150, 33);
		contentPane.add(testLevelButton);
		
		// Add the level view
		levelBuilderView.setBounds(50, 50, 900, 900);
		contentPane.add(levelBuilderView);

		
	}
	
	public void initControllers(){
		levelBuilderView.initControllers();
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
		exportGameButton.addActionListener(new ExportLevelHandler(app, m));
		testLevelButton.addActionListener(new TestLevelHandler(app, m));
	}
	


	@Override
	public void keyTyped(KeyEvent e) {} // NOOP

	@Override
	public void keyPressed(KeyEvent e) {
				
		if(e.isControlDown()){
			isControlPressed = true;
		}
		
		if(e.getKeyCode() == 90 && isControlPressed){
			try{
				UndoManager.popMove().executeUndo();
			}
			catch(EmptyStackException ex){} // NOOP
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(!e.isControlDown()){
			isControlPressed = false;
		}
		
	}
	
	public LevelBuilderView getLevelBuilderView(){
		return this.levelBuilderView;
	}
	
	public void refresh(){
		contentPane.remove(levelBuilderView);
		levelBuilderView = new LevelBuilderView(m.getLevel(), app, m); 
		levelBuilderView.initView();
		levelBuilderView.setBounds(50, 50, 900, 900);
		levelBuilderView.initControllers();
		contentPane.add(levelBuilderView);
		contentPane.revalidate();
		contentPane.repaint();
		this.toFront();
		this.requestFocus();
	}
	

}
