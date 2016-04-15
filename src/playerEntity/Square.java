
/**
 * 
 */
package playerEntity;

/**
 * @author kacper
 *
 */
public class Square {
	int anchorRelX;
	int anchorRelY;
	Tile tile;
	
	public Square(int anchorRelX, int anchorRelY, Tile t) {
		this.anchorRelX = anchorRelX;
		this.anchorRelY = anchorRelY;
		this.tile = t;
	}
	
	public void setX(int k) {
		anchorRelX = k;
	}
	
	public void setY(int k) {
		anchorRelY = k;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	public void setTile(Tile t) {
		this.tile = t;
	}	
	
	public int getRelX(){
		return anchorRelX;
	}
	
	public int getRelY(){
		return anchorRelY;
	}
}
