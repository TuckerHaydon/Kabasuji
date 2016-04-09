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
	
}
