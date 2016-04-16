package builderBoundary;

import java.awt.Color;
import java.awt.Graphics;

import builderEntity.Board;
import builderEntity.BoardElt;
import builderEntity.NumberedBoardElt;
import builderEntity.PlayableBoardElt;
import builderEntity.UnplayableBoardElt;


public class BoardView extends View {

	static int BOARD_WIDTH = 600;
	static int SQUARE_WITH = BOARD_WIDTH/12;
	Board b;
	
	public BoardView(Board b){
		this.b = b;
	}
	
	public void initView(){
		this.setSize(500, 500);
	}
	
	public int getBoardWidth(){
		return BOARD_WIDTH;
	}
	
	public int getSquareWidth(){
		return SQUARE_WITH;
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
					else if(elts[row][col] instanceof NumberedBoardElt){
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
				g.fillRect(SQUARE_WITH * col, SQUARE_WITH * row, SQUARE_WITH, SQUARE_WITH);
				
				g.setColor(Color.BLACK);
				g.drawRect(SQUARE_WITH * col, SQUARE_WITH * row, SQUARE_WITH, SQUARE_WITH);
			}
		}
    }
	
}
