package builderBoundary;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import builderController.BankController;
import builderController.BoardController;
import builderBoundary.BoardView;
import builderController.BullpenController;
import builderController.SetAllowedTimeHandler;
import builderController.SetAllowedTimeMove;
import builderController.SetBoardEltColorHandler;
import builderController.SetBoardEltNumHandler;
import builderController.SetBoardEltTypeHandler;
import builderController.SetHintHandler;
import builderController.SetLevelTypeHandler;
import builderController.SetNumAllowedMovesHandler;
import builderEntity.BuilderModel;
import builderEntity.Level;
import builderEntity.Tile;
import builderEntity.Bank;
import playerController.LoadGame;

/**
 * 
 * @author tuckerhaydon
 * @author jwilder
 *
 */
public class LevelBuilderView extends JPanel{
	
	BullpenView bullpenView;
	BankView bankView;  //change back later
	BoardView boardView;
	JCheckBox hintBox;
	Level lvl;
	BuilderModel m;
	KabasujiBuilderApplication app;
	JLabel timeLabel, numLabel;
	JTextField timeField, numField;
	JComboBox<String> boardEltNumBox, levelTypeBox, boardEltTypeBox, boardEltColorsBox;
	String boardEltNums[] = {"1", "2", "3", "4", "5", "6"}, 
			levelTypes[] = {"puzzle", "release", "lightning"}, 
			numberedBoardEltTypes[] = {"playable", "unplayable", "numbered"},
			regularBoardEltTypes[] = {"playable", "unplayable"},
			boardEltColors[] = {"red", "blue", "green"};
	
	public LevelBuilderView(Level lvl, KabasujiBuilderApplication app, BuilderModel m){
		super();
		this.lvl = lvl;
		this.app = app;
		this.m = m;
					
		bullpenView = new BullpenView(lvl.getBullpen());
		boardView = new BoardView(lvl.getBoard());
		bankView = new BankView(new Bank());	// TODO fix this
		
		boardEltNumBox = new JComboBox<String>(boardEltNums);
		levelTypeBox = new JComboBox<String>(levelTypes);
		boardEltTypeBox = new JComboBox<String>(numberedBoardEltTypes);
		boardEltColorsBox = new JComboBox<String>(boardEltColors);
		hintBox = new JCheckBox("Hint");
		
		timeField = new JTextField();
		timeLabel = new JLabel("Time in Sec.");
		
		numField = new JTextField();
		numLabel = new JLabel("Num Moves");
		
		// Set the combo boxes to a default selected value
		boardEltNumBox.setSelectedItem(m.getSelectedNumber());
		levelTypeBox.setSelectedItem(lvl.getLevelType().toLowerCase());
		boardEltColorsBox.setSelectedItem(m.getSelectedColor().toLowerCase());
		boardEltTypeBox.setSelectedItem(m.getSelectedBoardEltType().toLowerCase());
	}
	
	public void initView(){
		
		
		// Init the subcomponents views
		bullpenView.initView();
		boardView.initView();
		bankView.initView();
		
		//set properties of the view
		this.setSize(900, 900);
		
		// No layout; using exact coordinates.
		setLayout(null);
		setBackground(new Color(255,192,203));
		
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
		
		hintBox.setBounds(605, 530, 100, 100);
		this.add(hintBox);
		
		timeField.setBounds(700, 650, 100, 35);
		this.add(timeField);
		
		timeLabel.setBounds(605,650,90,35);
		this.add(timeLabel);
		
		numField.setBounds(700, 700, 100, 35);
		this.add(numField);
		
		numLabel.setBounds(605, 700, 90, 35);
		this.add(numLabel);
		
		this.changeViewLevelType(this.getLevel().getLevelType());
		
		
	}
	
	public void initControllers(){
		
		// Allow mouse functionality for board, bullpen, and bank.
		boardView.addMouseAdapter(new BoardController(app, m, boardView));
		bullpenView.addMouseAdapter(new BullpenController(app, m, bullpenView, bankView));
		bankView.addMouseAdapter(new BankController(app, m, bankView, bullpenView));
		
		// Action listeners for the various elements
		boardEltNumBox.addActionListener(new SetBoardEltNumHandler(app, m, boardEltNumBox));
		levelTypeBox.addActionListener(new SetLevelTypeHandler(app, m, levelTypeBox));
		boardEltTypeBox.addActionListener(new SetBoardEltTypeHandler(app, m, boardEltTypeBox));
		boardEltColorsBox.addActionListener(new SetBoardEltColorHandler(app, m, boardEltColorsBox));
		hintBox.addActionListener(new SetHintHandler(app, m, hintBox));
		timeField.addActionListener(new SetAllowedTimeHandler(app, m, timeField));
		numField.addActionListener(new SetNumAllowedMovesHandler(app, m, numField));
	}
	
	public void changeViewLevelType(String levelType){
		switch(levelType.toLowerCase())
		{
		case "puzzle":
			
			// No time for the puzzle level
			timeField.setVisible(false);
			timeLabel.setVisible(false);
			
			// Num moves in puzzle level
			numField.setVisible(true);
			numLabel.setVisible(true);
			
			boardEltNumBox.setVisible(false);
			boardEltColorsBox.setVisible(false);
			boardEltTypeBox.setModel(new DefaultComboBoxModel<String>(regularBoardEltTypes));
			break;
		case "lightning":
			
			// Time for lightning level
			timeField.setVisible(true);
			timeLabel.setVisible(true);
			
			// No num moves in puzzle level
			numField.setVisible(false);
			numLabel.setVisible(false);
			
			boardEltNumBox.setVisible(false);
			boardEltColorsBox.setVisible(false);
			boardEltTypeBox.setModel(new DefaultComboBoxModel<String>(regularBoardEltTypes));
			break;
		case "release":
			
			// No time for the puzzle level
			timeField.setVisible(false);
			timeLabel.setVisible(false);
			
			// No num moves in puzzle level
			numField.setVisible(false);
			numLabel.setVisible(false);
			
			this.changeViewEltType(m.getSelectedBoardEltType());
			boardEltTypeBox.setModel(new DefaultComboBoxModel<String>(numberedBoardEltTypes));
			break;
		default:
			System.err.println("Bad input in LevelbuilderView: "+levelType);
			break;
		}
		
		// Update the UI
		this.refresh();
		
	}
	
	public void changeViewEltType(String eltType){
		switch(eltType){
		case "playable":
			boardEltNumBox.setVisible(false);
			boardEltColorsBox.setVisible(false);
			hintBox.setVisible(true);
			break;
		case "unplayable":
			boardEltNumBox.setVisible(false);
			boardEltColorsBox.setVisible(false);
			hintBox.setVisible(false);
			break;
		case "numbered":
			boardEltNumBox.setVisible(true);
			boardEltColorsBox.setVisible(true);
			hintBox.setVisible(true);
			break;
		default:
			System.out.println("eltTYpe");
			break;
		}
		
		// Update the UI
		this.refresh();
	}
	
	public void refresh(){
		bullpenView.repaint();
		bankView.repaint();
		boardView.repaint();
		
		hintBox.revalidate();
		boardEltNumBox.revalidate();
		boardEltTypeBox.revalidate();
		boardEltColorsBox.revalidate();
		
		hintBox.repaint();
		boardEltNumBox.repaint(); 
		levelTypeBox.repaint();
		boardEltTypeBox.repaint(); 
		boardEltColorsBox.repaint();
		
	}

	public Level getLevel(){
		return this.lvl;
	}
	
	public void setLevel(Level lev){
		this.lvl = lev;
	}
	
	public BullpenView getBullpenView(){
		return this.bullpenView;
	}
	
	public void setBullpenView(BullpenView bpv){
		this.bullpenView = bpv;
	}
	
	public BankView getBankView(){
		return this.bankView;
	}
	
	public void setBankView(BankView bkv){
		this.bankView = bkv;
	}

	public BoardView getBoardView() {
		return this.boardView;
	}
	
	public void setBoardView(BoardView bv){
		this.boardView = bv;
	}
}
