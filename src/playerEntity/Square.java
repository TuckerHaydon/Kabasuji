
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
	
	public int getRelX(){
		return anchorX;
	}
	
	public int getRelY(){
		return anchorY;
	}
}
