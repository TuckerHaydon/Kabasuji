/**
 * 
 */
package playerEntity;

/**
 * @author kacper
 *
 */
public class Tile {
	Square[] squares = new Square[6];
	Anchor anchor;
	String location;
	
	Tile(int[][] coords, String location) {
		//first coordinate must be that of the anchor
		if(coords.length != 6) throw new RuntimeException("Error in tile constructor.");
		if(coords[0][0] != 0 && coords[0][1] != 0) throw new RuntimeException("Error in tile constructor.");
		anchor = new Anchor(0,0,this);
		for(int i = 0; i < 6; i++) {
			squares[i].setX(coords[i][0]) ;
			squares[i].setY(coords[i][1]) ;
			squares[i].setTile(this);
		}
		
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
	
	public Square getSquare(int x, int y) {
		for(int i = 0; i < 6; i++) {
			if(squares[i].getX() == x && squares[i].getY() == y) {
				return squares[i];
			}
		}
		return null;
	}
	
}
