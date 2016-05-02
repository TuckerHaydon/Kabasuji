package builderEntity;

import builderEntity.Anchor;
import builderEntity.Square;
import builderEntity.TileParser;

/**
 * 
 * Tile Class 
 * Used to represent a hexomino piece.
 * Tiles are made of an array of Squares.
 * Each Tile consists of a Square which acts as its 
 * anchor. 
 * 
 * @see Square
 * 
 * @author tuckerhaydon
 *
 */
public class Tile {
	Square[] squares;
	Anchor anchor;
	String location;
	int referenceNumber;
	
	/**
	 * Tile constructor 
	 * Tiles are specified by their reference number and a location
	 * being either the bullpen or the board
	 * @param referenceNumber - reference number of the tile
	 * @param location - bullpen or board
	 */
	public Tile(int referenceNumber, String location){
		
		this.squares = TileParser.getSquares(referenceNumber, this);
		this.location = location;
		this.referenceNumber = referenceNumber;
		
		anchor = new Anchor(0,0, this);
	}

	
	public Tile() {
		squares = new Square[6];
	}
	
	/**
	 * Sets the squares of the Tile
	 * @param s
	 */
	public void setSquares(Square s[]){
		this.squares = s;
	}
	
	/**
	 * Returns the Squares in a Tile
	 * @return array of squares
	 */
	public Square[] getSquares(){
		return this.squares;
	}
	
	/**
	 * Returns the reference number of the tile
	 * @return
	 */
	public int getReferenceNumber(){
		return this.referenceNumber;
	}
	
	
	
	
}
