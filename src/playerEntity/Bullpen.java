package playerEntity;

import java.util.ArrayList;

/**
 * Bullpen class used to store tiles that are playable within a Level
 * Each type of level uses this Bullpen class to display tiles in the 
 * BullpenView boundary. Tiles are added using the corresponding reference number
 * @see BullpenController
 * @see BullpenView
 * @author kacper puczydlowski
 *
 */
public class Bullpen {

	ArrayList<Tile> tiles;
	
	/**
	 * Bullpen constructor
	 * @param hexominoes the indexes of the Tiles to be added
	 */
	public Bullpen(ArrayList<Integer> hexominoes) {
		
		tiles = new ArrayList<Tile>();
		for(Integer i: hexominoes){
			tiles.add(new Tile(i, "Bullpen"));
		}
	}
	
	/**
	 * Adds a Tile to the ArrayList
	 * @param t
	 * @return
	 */
	public boolean addTile(Tile t) {
		return tiles.add(t);
	}
	
	/**
	 * Adds a Tile to the ArrayList by reference number
	 * @param refNum reference number of the Tile
	 * @return
	 */
	public boolean addTile(int refNum) {
		for(Tile t: tiles){
			if(t.getReferenceNumber() == refNum) return tiles.add(t);
		}
		return false;
	}
	
	/**
	 * Removes a Tile from the ArrayList
	 * @param t Tile to be removed
	 * @return
	 */
	public boolean removeTile(Tile t) {
		return tiles.remove(t);
	}
	
	/**
	 * Returns the ArrayList of Tiles
	 * @return
	 */
	public ArrayList<Tile> getTiles(){
		return tiles;
	}
}
