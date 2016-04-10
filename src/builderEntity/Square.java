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
		
	void setAnchorRelX(int x){
		this.anchorRelX = x;
	}
	
	int getAnchorRelX(){
		return this.anchorRelX;
	}
	
	void setAnchorRelY(int y){
		this.anchorRelY = y;
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
}
