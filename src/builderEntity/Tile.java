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
}
