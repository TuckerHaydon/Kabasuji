package playerEntity;

/**
 * Square Class
 * Used to construct Tiles
 * This is done by creating an array of Squares
 * One of which is an Anchor (relative X,Y of 0,0)
 * Squares are specified based on their location relative to this Anchor
 * X and Y coordinates are integers
 * @author kacper puczydlowski, tuckerhaydon
 *
 */
public class Square {
	int anchorRelX;
	int anchorRelY;
	Tile tile;
	
	/**
	 * Square Constructor
	 * specifies the relative X,Y positions and the Tile to which it belongs
	 * @param anchorRelX relative X
	 * @param anchorRelY relative Y
	 * @param t Tile to which it belongs
	 */
	public Square(int anchorRelX, int anchorRelY, Tile t) {
		this.anchorRelX = anchorRelX;
		this.anchorRelY = anchorRelY;
		this.tile = t;
	}
	
	/**
	 * sets the relative X position
	 * @param k
	 */
	public void setX(int k) {
		anchorRelX = k;
	}
	
	/**
	 * sets the relative Y position
	 * @param k
	 */
	public void setY(int k) {
		anchorRelY = k;
	}
	
	/**
	 * Returns the Tile
	 * @return
	 */
	public Tile getTile() {
		return tile;
	}
	
	/**
	 * Sets the tile 
	 */
	public void setTile(Tile t) {
		this.tile = t;
	}	
	
	/**
	 * Returns the relative X
	 * @return
	 */
	public int getRelX(){
		return anchorRelX;
	}
	
	/**
	 * Returns the relative Y
	 * @return
	 */
	public int getRelY(){
		return anchorRelY;
	}
	
	public String toString(){
		return anchorRelX + ", " + anchorRelY;
	}
}
