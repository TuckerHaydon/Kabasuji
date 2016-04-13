package playerBoundary;

import java.awt.Color;

import playerEntity.Board;

/*
 * Author: Damani
 */

public class BoardView extends View{
	Board b;
	
	public BoardView(Board b){
		this.b = b;
	}
	
	public void initView(){
		this.setBackground(Color.RED);
	}
	
	public void initControllers(){
		
	}
	
}
