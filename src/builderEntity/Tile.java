package builderEntity;

import builderEntity.Anchor;
import builderEntity.Square;
import builderEntity.TileParser;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class Tile {
	Square[] squares;
	Anchor anchor;
	String location;
	int referenceNumber;
	
	public Tile(int referenceNumber, String location){
		
		this.squares = TileParser.getSquares(referenceNumber, this);
		this.location = location;
		this.referenceNumber = referenceNumber;
		
		anchor = new Anchor(0,0, this);
	}

	
	public Tile() {
		squares = new Square[6];
	}
	
	public void setSquares(Square s[]){
		this.squares = s;
	}
	
	public Square[] getSquares(){
		return this.squares;
	}
	
	public int getReferenceNumber(){
		return this.referenceNumber;
	}
	
	
	
	
}
