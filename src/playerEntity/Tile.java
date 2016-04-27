package playerEntity;

/**
 * @author kacper
 *
 */
public class Tile {
	Square[] squares = new Square[6];
	Anchor anchor;
	String location;
	int referenceNumber;
	
	public Tile(int referenceNumber, String location){
		
		this.squares = TileParser.getSquares(referenceNumber, this);
		this.location = location;
		this.referenceNumber = referenceNumber;
		anchor = new Anchor(0,0, this);
	}
	
	public int getReferenceNumber() {
		return this.referenceNumber;
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
	
	public Square getSquare(int x, int y) {
		for(int i = 0; i < 6; i++) {
			if(squares[i].getRelX() == x && squares[i].getRelY() == y) {
				return squares[i];
			}
		}
		return null;
	}
	
	public Square[] getSquares(){
		return this.squares;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public Anchor getAnchor(){
		return this.anchor;
	}
	
	public void setAnchor(Anchor anchor){
		this.anchor = anchor;
	}

	/**
	 * @return
	 */
	public int getRefNum() {
		// TODO Auto-generated method stub
		return getReferenceNumber();
	}
}
