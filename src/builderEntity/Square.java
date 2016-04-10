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
}
