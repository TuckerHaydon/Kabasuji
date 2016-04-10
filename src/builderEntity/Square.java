package builderEntity;

public class Square {

	int anchorRelX;
	int anchorRelY;
	Tile owner;
	
	Square(int relX, int relY, Tile owner){
		this.anchorRelX = relX;
		this.anchorRelY = relY;
		this.owner = owner;
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
