package playerBoundary;


import playerEntity.Tile;

import java.awt.Color;
import java.awt.Graphics;
import playerEntity.Square;


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

	
	public void initView() {
		
	}
	

	@Override
	public void initControllers() {
		// TODO Auto-generated method stub
		
	}
	
	public Tile getTile(){
		return t;
	}

}
