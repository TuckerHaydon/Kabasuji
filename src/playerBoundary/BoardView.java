package playerBoundary;

import java.awt.Color;
import java.awt.Graphics;

import playerController.BoardController;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.GameModel;
import playerEntity.NumberBoardElt;
import playerEntity.PlayableBoardElt;
import playerEntity.UnplayableBoardElt;

/*
 * Author: Damani
 */

public class BoardView extends View{
	Board b;
	KabasujiPlayerApplication app;
	GameModel m;
	private static int WIDTH = 45;
	
	public BoardView(Board b, KabasujiPlayerApplication app, GameModel m){
		this.b = b;
		this.app=app;
		this.m=m;
	}
	
	public void initView(){
	
	}
	
	public void initControllers(){
		setMouseAdapter(new BoardController(b, app, WIDTH));
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BoardElt[][] elts = b.getBoardElts();
		for(int row = 0; row < elts.length; row++){
			for(int col = 0; col < elts[0].length; col++){
				
				Color squareColor = Color.BLACK;
				
				if(elts[row][col] instanceof PlayableBoardElt){
					if(((PlayableBoardElt)elts[row][col]).isHint()){
						squareColor = Color.YELLOW;
					}
					else if(elts[row][col] instanceof NumberBoardElt){
						squareColor = Color.RED;
					}
					else{
						squareColor = Color.GREEN;
					}
				}
				else if(elts[row][col] instanceof UnplayableBoardElt){
					squareColor = Color.BLACK;
				}

				
				g.setColor(squareColor);
				g.fillRect(WIDTH * col, WIDTH * row, WIDTH, WIDTH);
				
				g.setColor(Color.BLACK);
				g.drawRect(WIDTH * col, WIDTH * row, WIDTH, WIDTH);
			}
		}
    } 
	
}
