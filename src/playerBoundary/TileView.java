package playerBoundary;

import playerEntity.Tile;

/* 
 * Author: Damani 
 */

public class TileView {
	
	Tile t;
	int x;
	int y;
	
	public TileView(Tile t){
		this.t = t;
	}
	
	public void setLocation (int x, int y){
		this.x = x;
		this.y = y;
	}
}
