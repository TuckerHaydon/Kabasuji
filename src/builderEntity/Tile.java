package builderEntity;

public class Tile {

	Square squares[];
	
	Tile(Square s[]){
		this.squares = s;
	}
	
	Tile() {
		squares = new Square[6];
	}
	
	void setSquares(Square s[]){
		this.squares = s;
	}
	
	Square[] getSquares(){
		return this.squares;
	}
	
}
