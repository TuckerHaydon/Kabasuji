/**
 * 
 */
package playerEntity;

import java.util.ArrayList;

/**
 * @author kacper
 *
 */
public class Tile {
	Square[] squares;
	Anchor anchor;
	String location;
	
	Tile(Square[] squares, Anchor anchor, String location) {
		if(squares.length != 6) {
			throw new RuntimeException("Invalid number of squares.");
		}
		
		this.squares = squares;
		this.anchor = anchor;
		this.location = location;
	}
	
	public void rotateRight() {
		int temp;
		for(Square square : squares) {
			temp = square.anchorX;
			square.anchorX = square.anchorY;
			square.anchorY = -temp;
		}
	}
	
	public void rotateLeft() {
		int temp;
		for(Square square : squares) {
			temp = square.anchorX;
			square.anchorX = -square.anchorY;
			square.anchorY = temp;
		}
	}
	
	public void flipVertical() {
		for(Square square : squares) {
			square.anchorY = -square.anchorY;
		}
	}
	
	public void flipHorizontal() {
		for(Square square : squares) {
			square.anchorX = -square.anchorX;
		}
	}
	
	public Tile(int referenceNumber, String location){
		
		// TODO actually implement the tile constructor with a reference number
		squares = new Square[6];
		squares[0] = new Square(0,0,this);
		squares[1] = new Square(1,0,this);
		squares[2] = new Square(2,0,this);
		squares[3] = new Square(3,0,this);
		squares[4] = new Square(4,0,this);
		squares[5] = new Square(5,0,this);
		this.anchor = new Anchor(-1, -1, this);
	}
	
	public Square[] getSquares(){
		return squares;
	}
	
}
