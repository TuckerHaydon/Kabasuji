package builderEntity;

import builderEntity.Anchor;
import builderEntity.Square;

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
			temp = square.anchorRelX;
			square.anchorRelX = square.anchorRelY;
			square.anchorRelY = -temp;
		}
	}
	
	public void rotateLeft() {
		int temp;
		for(Square square : squares) {
			temp = square.anchorRelX;
			square.anchorRelX = -square.anchorRelY;
			square.anchorRelY = temp;
		}
	}
	
	public void flipVertical() {
		for(Square square : squares) {
			square.anchorRelY = -square.anchorRelY;
		}
	}
	
	public void flipHorizontal() {
		for(Square square : squares) {
			square.anchorRelX = -square.anchorRelX;
		}
	}
	
	Tile() {
		squares = new Square[6];
	}
	
	void setSquares(Square s[]){
		this.squares = s;
	}
	
	Square[] getSquares(){
		return this.squares;
	}
	
}
