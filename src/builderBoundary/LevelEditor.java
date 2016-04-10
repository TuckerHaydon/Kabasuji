package builderBoundary;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	
	public LevelEditor(KabasujiBuilderApplication app){
		super();
		
		this.app = app;
		
		levelBuilderView = new LevelBuilderView(m.getLevel()); 
		
		// Create all of the components
		nextBankTiles = new JButton("Next");
		prevBankTiles = new JButton("Prev");
		nextBullpenTiles = new JButton("Next");
		prevBullpenTiles = new JButton("Prev");
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
		
		// Set the frame properties
		this.setSize(1000, 1000);
		this.setTitle("Level Editor");
		
		// Set the frame layout
		getContentPane().setLayout(new GridLayout(5,5));
		
		// LevelBuilderView stuff
		levelBuilderView.setSize(200, 200);
		levelBuilderView.initView();
		
		// Add all of the components
		this.add(nextBankTiles);
		this.add(prevBankTiles);
		this.add(nextBullpenTiles);
		this.add(prevBullpenTiles);
		this.add(exportGameButton);
		this.add(goToMenuButton);
		this.add(boardEltNumBox);
		this.add(levelTypeBox);
		this.add(boardEltColorsBox);
		this.add(boardEltTypeBox);
		this.add(levelBuilderView);
		
	}
	
	public void initControllers(){
		// TODO add all the controllers
		levelBuilderView.initControllers();
		goToMenuButton.addActionListener(new NavigateMainMenu(app));
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
