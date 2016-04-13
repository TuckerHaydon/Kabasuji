package playerBoundary;

import playerEntity.Tile;

/* 
 * Author: Damani 
 */

public class TileView extends View {
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

	@Override
	void initView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void initControllers() {
		// TODO Auto-generated method stub
		
	}
}
