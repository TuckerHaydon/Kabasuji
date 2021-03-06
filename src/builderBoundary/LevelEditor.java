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
import builderController.RedoManager;
import builderEntity.BuilderModel;

/**
 * A window for the level editor. Contains an export game button, go to menu button, and test level button.
 * @author tuckerhaydon
 *
 */
public class LevelEditor extends JFrame implements KeyListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JButton exportGameButton, goToMenuButton,testLevelButton;
	LevelBuilderView levelBuilderView;
	JPanel contentPane;	
	boolean isControlPressed = false, isShiftPressed = false;

	/**
	 * Constructor for the level editor. Initializes the various buttons.
	 * @param app - the top-level Kabasuji builder application
	 * @param m - the top-level builder model
	 */
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
				
	}
	
	/**
	 * Initializes all of the buttons and window features on the level editor.
	 */
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
	
	/**
	 * Registers all of the controllers to their respective buttons/views.
	 */
	public void initControllers(){
		levelBuilderView.initControllers();
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
		exportGameButton.addActionListener(new ExportLevelHandler(app, m));
		testLevelButton.addActionListener(new TestLevelHandler(app, m));
	}
	


	@Override
	public void keyTyped(KeyEvent e) {} // NOOP
	
	/**
	 * Ctrl+Z to undo 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
				
		if(e.isControlDown()){
			isControlPressed = true;
		}
		
		if(e.isShiftDown()){
			isShiftPressed = true;
		}
		
		if(e.getKeyCode() == 90 && isControlPressed && !isShiftPressed){
			try{
				UndoManager.popMove().executeUndo();
				System.out.println("Undo");
			}
			catch(EmptyStackException ex){System.out.println("No moves to undo");} // NOOP
		}
		
		if(e.getKeyCode() == 90 && isShiftPressed && isControlPressed){
			try{
				RedoManager.popMove().redoMove();
				System.out.println("Redo");
			}
			catch(EmptyStackException ex){System.out.println("No moves to redo");} // NOOP
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(!e.isControlDown()){
			isControlPressed = false;
		}
		
		if(!e.isShiftDown()){
			isShiftPressed = false;
		}
		
	}
	
	/**
	 * Get current level builder view
	 * @return - the current level builder view
	 */
	public LevelBuilderView getLevelBuilderView(){
		return this.levelBuilderView;
	}
	
	/**
	 * Refreshes the window to reflect changes
	 */
	public void refresh(){
		
		contentPane.remove(levelBuilderView);
		levelBuilderView = new LevelBuilderView(m.getLevel(), app, m); 
		levelBuilderView.initView();
		levelBuilderView.setBounds(50, 50, 900, 900);
		levelBuilderView.initControllers();
		contentPane.add(levelBuilderView);

		// Bring to focus for the key listener
		 this.toFront();
		 this.requestFocus();
		
		// Refresh all of the components
		contentPane.revalidate();
		contentPane.repaint();
		levelBuilderView.refresh();
		
	}
	
	/**
	 * Repaints the level editor window
	 */
	public void repaintLevelEditor(){	
		// Bring to focus for the key listener
		this.toFront();
		this.requestFocus();
		
		// Refresh all of the components
		contentPane.repaint();
		levelBuilderView.refresh();
	}
	

}
