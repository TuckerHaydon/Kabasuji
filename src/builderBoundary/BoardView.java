package builderBoundary;

import java.awt.Color;
import java.awt.Dimension;


import builderEntity.Board;


public class BoardView extends View {

	Board b;
	
	public BoardView(Board b){
		this.b = b;
	}
	
	public void initView(){
		this.setBackground(new Color(255, 50, 50));
		this.setSize(1000, 200);
		this.setPreferredSize(new Dimension(1000, 200));
	}
	
}
