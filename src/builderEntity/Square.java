package builderEntity;

import builderEntity.Tile;

/**
 * 
 * Square Class
 * An array of squares is used to construct Tiles.
 * Each Tile has a Square representing the Anchor (relative X,Y of 0,0)
 * Squares are specified based on their location relative to this Anchor
 * 
 * @author
 *
 */
public class Square {

	int anchorRelX;
	int anchorRelY;
	Tile owner;
	
	/**
	 * Square Constructor
	 * specifies the relative X,Y positions and the Tile to which it belongs
	 * @param anchorRelX relative X
	 * @param anchorRelY relative Y
	 * @param t Tile to which it belongs
	 */
	public Square(int anchorRelX, int anchorRelY, Tile tile) {
		this.anchorRelX = anchorRelX;
		this.anchorRelY = anchorRelY;
		this.owner = tile;
	}	
		
	/**
	 * sets the relative X position
	 * @param k
	 */
	public void setX(int k) {
		anchorRelX = k;
	}
	
	/**
	 * sets the relative Y position
	 * @param k
	 */
	public void setY(int k) {
		anchorRelY = k;
	}
	
	/**
	 * returns the relative X position
	 * @return X
	 */
	public int getAnchorRelX(){
		return this.anchorRelX;
	}

	/**
	 * returns the relative Y position
	 * @return Y
	 */
	public int getAnchorRelY(){
		return this.anchorRelY;
	}
	
	/**
	 * sets the owner of the Tile to the param
	 * @param o
	 */
	public void setOwner(Tile o){
		this.owner = o;
	}
	
	/***
	 * returns the Tile to which the square is associated
	 * @return
	 */
	public Tile getOwner(){
		return this.owner;
	}
	
	/**
	 * sets the owner of the Tile to the param
	 * @param o
	 */
	public void setTile(Tile t) {
		this.owner = t;
	}	
}
