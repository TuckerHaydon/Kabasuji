
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
	
	public Square(int anchorX, int anchorY, Tile tile) {
		this.anchorX = anchorX;
		this.anchorY = anchorY;
		this.tile = tile;
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
	
	public int getRelX(){
		return anchorX;
	}
	
	public int getRelY(){
		return anchorY;
	}
}
