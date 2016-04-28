package playerBoundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import playerController.BoardController;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.GameModel;
import playerEntity.NumberedBoardElt;
import playerEntity.PlayableBoardElt;
import playerEntity.UnplayableBoardElt;

/**
 * The class is in charge of displayed the Board. It takes in as parameters a KabasujiPlayerApplication, a GameModel, and a Board. 
 * @author tuckerhaydon
 */
public class BoardView extends View{
	Board b;
	private static int SQUARE_WIDTH = 40;
	
	/**
	 * Constructor. Validates that none of the parameters are null.
	 * @param app The top-level KabasujiPlayerApplication
	 * @param m The top-level GameModel
	 * @param b The board to be displayed
	 */
	public BoardView(KabasujiPlayerApplication app, GameModel m, Board b){
		super(app, m);
		
		if(app == null || m == null || b == null){
			throw new RuntimeException();
		}
		
		this.b = b;
	}
	
	/**
	 * Sets the background color of the board.
	 */
	public void initView(){
		setBackground(new Color(255, 228, 225));
	}
	
	/**
	 * Returns the width of a square on the board
	 * @return int The width of a square on the board
	 */
	public int getSquareWidth(){
		return SQUARE_WIDTH;
	}
	
	/**
	 * Initializes the mouse controllers for the board
	 */
	public void initControllers(){
		setMouseAdapter(new BoardController(app, m, b, SQUARE_WIDTH));
	}
	
	/**
	 * Displays the board. Iterates through all of the squares in the board and paints each one.
	 */
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BoardElt[][] elts = b.getBoardElts();
		for(int row = 0; row < elts.length; row++){
			for(int col = 0; col < elts[0].length; col++){
				
				Color squareColor = Color.BLACK;
				
				if(elts[row][col] instanceof PlayableBoardElt){
					if(((PlayableBoardElt)elts[row][col]).getCovered()){
						squareColor = Color.PINK;
					}
					else if(((PlayableBoardElt)elts[row][col]).isHint()){
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
