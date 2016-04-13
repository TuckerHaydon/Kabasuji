package builderBoundary;

import java.awt.Color;

import javax.swing.JPanel;

import builderEntity.Board;

public class BoardView extends JPanel {

	Board b;
	
	public BoardView(Board b){
		this.b = b;
	}
	
	void initView(){
		this.setBackground(new Color(255, 50, 50));
		this.setBounds(0, 0, 4000, 4000);
	}
}
