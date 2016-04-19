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


public class BoardView extends View{
	Board b;
	KabasujiPlayerApplication app;
	GameModel m;
	private static int SQUARE_WIDTH = 40;
	
	public BoardView(Board b, KabasujiPlayerApplication app, GameModel m){
		this.b = b;
		this.app=app;
		this.m=m;
	}
	
	public void initView(){
		setBackground(new Color(255, 228, 225));
	}
	
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}
	
	public void initControllers(){
		setMouseAdapter(new BoardController(b, app, SQUARE_WIDTH));
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
						squareColor = Color.WHITE;
					}
				}
				else if(elts[row][col] instanceof UnplayableBoardElt){
					squareColor = Color.BLACK;
				}

				
				g.setColor(squareColor);
				g.fillRect(SQUARE_WIDTH * col, SQUARE_WIDTH * row, SQUARE_WIDTH, SQUARE_WIDTH);
				
				g.setColor(Color.BLACK);
				g.drawRect(SQUARE_WIDTH * col, SQUARE_WIDTH * row, SQUARE_WIDTH, SQUARE_WIDTH);
			}
		}
    } 
	
}
