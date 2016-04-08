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

public class LevelEditor extends JFrame implements KeyListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	JButton nextBankTiles, prevBankTiles, nextBullpenTiles, prevBullpenTiles;
	JButton exportGameButton, goToMenuButton;
	JLabel timeLabel, movesLabel, numLabel;
	JTextField timeAllowed, numMovesAllowed;
	JComboBox<String> boardEltNumBox, levelTypeBox, boardEltTypeBox, boardEltColorsBox;
	String boardEltNums[], levelTypes[], boardEltTypes[], boardEltColors[];
	
	public LevelEditor(KabasujiBuilderApplication app){
		super();
		
		this.app = app;
		
		// Create all of the components
		nextBankTiles = new JButton();
		prevBankTiles = new JButton();
		nextBullpenTiles = new JButton();
		prevBullpenTiles = new JButton();
		exportGameButton = new JButton();
		goToMenuButton = new JButton();
		
		// TODO implement all the other shit.
		
	}
	
	public void initView(){
		
		// Set the frame properties
		this.setSize(1000, 1000);
		this.setTitle("Level Editor");
		
		// Set the frame layout
		getContentPane().setLayout(new GridLayout(5,5));
		
		// Add all of the components
		this.add(nextBankTiles);
		this.add(prevBankTiles);
		this.add(nextBullpenTiles);
		this.add(prevBullpenTiles);
		this.add(exportGameButton);
		this.add(goToMenuButton);
	}
	
	public void initControllers(){
		// TODO add all the controllers
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
