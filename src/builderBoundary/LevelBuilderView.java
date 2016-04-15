package builderBoundary;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import builderController.BoardController;
import builderEntity.Level;
import builderEntity.Tile;
import builderEntity.TileBank;
import playerController.LoadGame;

public class LevelBuilderView extends JPanel{
	
	BullpenView bullpenView;
	BullpenView bankView;  //change back later
	BoardView boardView;
	Level lvl;
	KabasujiBuilderApplication app;
	JLabel timeLabel, movesLabel, numLabel;
	JTextField timeAllowed, numMovesAllowed;
	JComboBox<String> boardEltNumBox, levelTypeBox, boardEltTypeBox, boardEltColorsBox;
	String boardEltNums[] = {"1", "2", "3", "4", "5", "6"}, 
			levelTypes[] = {"puzzle", "release", "lightning"}, 
			boardEltTypes[] = {"playable", "unplayable", "hint", "numbered"},
			boardEltColors[] = {"red", "blue", "green"};
	
	public LevelBuilderView(Level lvl, KabasujiBuilderApplication app){
		this.lvl = lvl;
		this.app = app;
		ArrayList<Tile> banklist = new ArrayList<Tile>();
			
		bullpenView = new BullpenView(lvl.getBullpen());
		boardView = new BoardView(lvl.getBoard());
		bankView = new BullpenView(lvl.getBullpen());	//change back later
		
		boardEltNumBox = new JComboBox<String>(boardEltNums);
		levelTypeBox = new JComboBox<String>(levelTypes);
		boardEltTypeBox = new JComboBox<String>(boardEltTypes);
		boardEltColorsBox = new JComboBox<String>(boardEltColors);
		
		// Set the combo boxes to a default selected value
		boardEltNumBox.setSelectedIndex(0);
		levelTypeBox.setSelectedIndex(0);
		boardEltColorsBox.setSelectedIndex(0);
		boardEltTypeBox.setSelectedIndex(0);
	}
	
	public void initView(){
		
		
		// bankView = new BankView();
		// Init the subcomponents views
		
		//aa
		bullpenView.initView();
		boardView.initView();
		
		//set properties of the view
		this.setSize(900, 900);
		
		// No layout; using exact coordinates.
		setLayout(null);
		setBackground(new Color(50,50,50));
		
		// Create the scrollPane
		JScrollPane bullpenScrollPane = new JScrollPane();
		bullpenScrollPane.setBounds(5, 5, 440, 190);
		bullpenScrollPane.getViewport().setBackground(new Color(255, 190, 190));
		add(bullpenScrollPane);
		
		JScrollPane bankScrollPane = new JScrollPane();
		bankScrollPane.setBounds(455, 5, 440, 190);
		bankScrollPane.getViewport().setBackground(new Color(255, 190, 190));
		add(bankScrollPane);
		
		// Add the bullpenView to the scrollPane
		bullpenScrollPane.setViewportView(bullpenView);
		bankScrollPane.setViewportView(bankView);
		
		// Add the boardView
		boardView.setBounds(0, 210, 600, 600);
		add(boardView);
		
		levelTypeBox.setBounds(605, 210, 200, 75);
		levelTypeBox.setBackground(new Color(255, 190, 190));
		this.add(levelTypeBox);
		
		boardEltTypeBox.setBounds(605, 290, 200, 75);
		boardEltTypeBox.setBackground(new Color(255, 190, 190));
		this.add(boardEltTypeBox);
		
		boardEltNumBox.setBounds(605, 370, 200, 75);
		boardEltNumBox.setBackground(new Color(255, 190, 190));
		this.add(boardEltNumBox);
		
		boardEltColorsBox.setBounds(605, 450, 200, 75);
		boardEltColorsBox.setBackground(new Color(255, 190, 190));
		this.add(boardEltColorsBox);
		
		this.add(bullpenView);
		this.add(bankView);
		this.add(boardView);
		
		
	}
	
	public void initControllers(){
		boardView.addMouseListener(new BoardController(boardView, app));
		// TODO add handlers for the bullpen and bank
	}

}
