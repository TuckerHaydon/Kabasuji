
/**
 * 
 */
package playerEntity;

/**
 * @author kacper
 *
 */
public class Square {
	int anchorX;
	int anchorY;
	Tile tile;
	
	Square(int anchorX, int anchorY, Tile tile) {
		this.anchorX = anchorX;
		this.anchorY = anchorY;
		this.tile = tile;
	}
	
	public int getX() {
		return anchorX;
	}
	
	public int getY() {
		return anchorY;
	}
	
	public void setX(int k) {
		anchorX = k;
	}
	
	public void setY(int k) {
		anchorY = k;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public void setTile(Tile t) {
		this.tile = t;
	}
}
