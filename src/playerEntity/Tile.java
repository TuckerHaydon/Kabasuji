package playerEntity;

/**
 * Tile Class 
 * Used for scoring onto the board.
 * Tiles are imported from a serialized file that's exported
 * from the Builder Application
 * @author kacper pucyzdlowski
 *
 */
public class Tile {
	Square[] squares = new Square[6];
	Anchor anchor;
	String location;
	int referenceNumber;
	
	/**
	 * Tile constructor 
	 * Tiles are specified by their reference number of a location
	 * being either the bullpen or the board
	 * @param referenceNumber reference number of the tile
	 * @param location bullpen or board
	 */
	public Tile(int referenceNumber, String location){
		
		this.squares = TileParser.getSquares(referenceNumber, this);
		this.location = location;
		this.referenceNumber = referenceNumber;
		anchor = new Anchor(0,0, this);
	}
	
	/**
	 * Returns the reference number of the tile
	 * @return
	 */
	public int getReferenceNumber() {
		return this.referenceNumber;
	}
	
	/** 
	 * Rotates the tile to the right by 
	 * altering the position of each square
	 */
	public void rotateRight() {
		int temp;
		for(Square square : squares) {
			temp = square.anchorRelX;
			square.anchorRelX = square.anchorRelY;
			square.anchorRelY = -temp;
		}
	}
	
	/** 
	 * Rotates the tile to the left by 
	 * altering the position of each square
	 */
	public void rotateLeft() {
		int temp;
		for(Square square : squares) {
			temp = square.anchorRelX;
			square.anchorRelX = -square.anchorRelY;
			square.anchorRelY = temp;
		}
	}
	
	/** 
	 * Flips the tile vertically by 
	 * inverting the y position of each square
	 */
	public void flipVertical() {
		for(Square square : squares) {
			square.anchorRelY = -square.anchorRelY;
		}
	}
	
	/** 
	 * Flips the tile vertically by 
	 * inverting the x position of each square
	 */
	public void flipHorizontal() {
		for(Square square : squares) {
			square.anchorRelX = -square.anchorRelX;
		}
	}
	
	/**
	 * Returns a square at a given relative X,Y location
	 * @param x
	 * @param y
	 * @return square 
	 */
	public Square getSquare(int x, int y) {
		for(int i = 0; i < 6; i++) {
			if(squares[i].getRelX() == x && squares[i].getRelY() == y) {
				return squares[i];
			}
		}
		return null;
	}
	
	/**
	 * Returns the Squares in a Tile
	 * @return
	 */
	public Square[] getSquares(){
		return this.squares;
	}
	
	/**
	 * Returns the location of the Tile
	 * @return
	 */
	public String getLocation(){
		return this.location;
	}
	
	/**
	 * Returns the Anchor
	 * @return
	 */
	public Anchor getAnchor(){
		return this.anchor;
	}
	
	/**
	 * Sets the Anchor
	 * @param anchor
	 */
	public void setAnchor(Anchor anchor){
		this.anchor = anchor;
	}
}
