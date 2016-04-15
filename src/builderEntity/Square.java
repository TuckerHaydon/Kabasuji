package builderEntity;

import builderEntity.Tile;

public class Square {

	int anchorRelX;
	int anchorRelY;
	Tile owner;
	
	Square(int anchorRelX, int anchorRelY, Tile tile) {
		this.anchorRelX = anchorRelX;
		this.anchorRelY = anchorRelY;
		this.owner = tile;
	}	
		
	public void setX(int k) {
		anchorRelX = k;
	}
	
	public void setY(int k) {
		anchorRelY = k;
	}
	
	
	int getAnchorRelX(){
		return this.anchorRelX;
	}

	int getAnchorRelY(){
		return this.anchorRelY;
	}
	
	void setOwner(Tile o){
		this.owner = o;
	}
	
	Tile getOwner(){
		return this.owner;
	}
	
	
	public void setTile(Tile t) {
		this.owner = t;
	}	
}
