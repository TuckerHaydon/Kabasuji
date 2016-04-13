package playerBoundary;

import java.awt.Color;
import java.awt.Graphics;

import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.NumberBoardElt;
import playerEntity.PlayableBoardElt;
import playerEntity.UnplayableBoardElt;

/*
 * Author: Damani
 */

public class BoardView extends View{
	Board b;
	private static int WIDTH = 50;
	
	public BoardView(Board b){
		this.b = b;
	}
	
	public void initView(){
		
	}
	
	public void initControllers(){
		
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BoardElt[][] elts = b.getBoardElts();
		for(int row = 0; row < elts.length; row++){
			for(int col = 0; col < elts[0].length; col++){
				
				Color squareColor = Color.BLACK;
				
				if(elts[row][col] instanceof PlayableBoardElt){
					squareColor = Color.GREEN;
				}
				else if(elts[row][col] instanceof UnplayableBoardElt){
					squareColor = Color.BLACK;
				}
				else if(elts[row][col] instanceof NumberBoardElt){
					squareColor = Color.RED;
				}
				
				g.setColor(squareColor);
				g.fillRect(WIDTH * row, WIDTH * col, WIDTH, WIDTH);
				
				g.setColor(Color.BLACK);
				g.drawRect(WIDTH * row, WIDTH * col, WIDTH, WIDTH);
			}
		}
    } 
	
}
