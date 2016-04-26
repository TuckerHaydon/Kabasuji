package builderBoundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import builderEntity.Board;
import builderEntity.BoardElt;
import builderEntity.NumberedBoardElt;
import builderEntity.PlayableBoardElt;
import builderEntity.UnplayableBoardElt;

/**
 * The view object for a Board. It is responsible for drawing the Board. Must be initialized WIDTH a non-null board. 
 * @author tuckerhaydon
 *
 */
public class BoardView extends View {

	static int BOARD_WIDTH = 600;
	static int SQUARE_WIDTH = BOARD_WIDTH/12;
	Board b;
	
	/**
	 * The BoardView constructor. Must be called WIDTH a non-null Board.
	 * @param b
	 */
	public BoardView(Board b){
		super();
		
		if(b == null){
			throw new RuntimeException();
		}
		
		this.b = b;
	}
	
	/**
	 * Sets the size of the View.
	 */
	public void initView(){
		this.setSize(500, 500);
	}
	
	/**
	 * Returns the width in pixels of the board
	 * @return int the width of the board
	 */
	public int getBoardWidth(){
		return BOARD_WIDTH;
	}
	
	/**
	 * Returns the width of the squares in the board
	 * @return in the width of the squares in the board
	 */
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}
	
	/**
	 * Returns the board object that this object displays
	 * @return Board the board object that this object displays
	 */
	public Board getBoard(){
		return b;
	}
	
	/**
	 * Paints the board. Iterates through every element in the board and fills in squares WIDTH colors corresponding to the element's type/status
	 */
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
						squareColor = Color.LIGHT_GRAY;
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
				
				if(elts[row][col] instanceof NumberedBoardElt){
					int num = ((NumberedBoardElt) elts[row][col]).getNum();
					Color numberColor =  ((NumberedBoardElt) elts[row][col]).getColor();
					
					g.setColor(numberColor);
					g.setFont(new Font("Arial", Font.BOLD, 25)); 
					g.drawString(""+num, SQUARE_WIDTH * col+(SQUARE_WIDTH)/3, SQUARE_WIDTH * row + (2*SQUARE_WIDTH)/3);
				}
			}
		}
    }
	
}
