package builderBoundary;

import java.awt.Color;
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

public class LevelEditor extends JFrame implements KeyListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JButton nextBankTiles, prevBankTiles, nextBullpenTiles, prevBullpenTiles;
	JButton exportGameButton, goToMenuButton;
	JLabel timeLabel, movesLabel, numLabel;
	JTextField timeAllowed, numMovesAllowed;
	JComboBox<String> boardEltNumBox, levelTypeBox, boardEltTypeBox, boardEltColorsBox;
	String boardEltNums[] = {"1", "2", "3", "4", "5", "6"}, 
			levelTypes[] = {"puzzle", "release", "lightning"}, 
			boardEltTypes[] = {"playable", "unplayable", "hint", "numbered"},
			boardEltColors[] = {"red", "blue", "green"};
	
	LevelBuilderView levelBuilderView;
	JPanel contentPane;

	
	public LevelEditor(KabasujiBuilderApplication app){
		super();
		
		this.app = app;
		m = new BuilderModel();

		
		levelBuilderView = new LevelBuilderView(m.getLevel(), app); 
		
		// Create all of the components
	
		exportGameButton = new JButton("Export");
		goToMenuButton = new JButton("Main Menu");
		
		boardEltNumBox = new JComboBox<String>(boardEltNums);
		levelTypeBox = new JComboBox<String>(levelTypes);
		boardEltTypeBox = new JComboBox<String>(boardEltTypes);
		boardEltColorsBox = new JComboBox<String>(boardEltColors);
		
		// Set the combo boxes to a default selected value
		boardEltNumBox.setSelectedIndex(1);
		levelTypeBox.setSelectedIndex(1);
		boardEltColorsBox.setSelectedIndex(1);
		boardEltTypeBox.setSelectedIndex(1);
		
		// TODO implement all the other shit.
		
	}
	
	public void initView(){
		
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
		contentPane.setBackground(new Color(50,50,50));
		contentPane.setLayout(null);
		
		// Add the buttons
		exportGameButton.setBounds(5, 5, 100, 33);
		contentPane.add(exportGameButton);
		
		goToMenuButton.setBounds(135, 5, 100, 33);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
