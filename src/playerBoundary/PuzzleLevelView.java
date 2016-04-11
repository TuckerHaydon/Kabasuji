package playerBoundary;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import playerEntity.Level;
import playerEntity.PuzzleLevel;

public class PuzzleLevelView extends LevelView{
	JLabel movesLeft;
	
	public PuzzleLevelView(PuzzleLevel puzzleLvl) {
		this.level = puzzleLvl;
		goToMenu = new JButton("Main Menu");
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		// Set properties of the frame
		this.setSize(200,200);
		
		// Set the layout
		getRootPane().setLayout(new GridLayout(3,1));
		
		// Add the buttons to the frame
		this.add(goToMenu);
		//this.setVisible(true);
	}

}