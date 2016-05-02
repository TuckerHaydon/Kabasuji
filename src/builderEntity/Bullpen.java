package builderEntity;

import java.util.ArrayList;

/**
 * 
 * Bullpen class
 * 
 * Used to store Tiles that are playable within a Level.
 * Each type of Level uses this Bullpen class to display tiles in the 
 * BullpenView boundary. Tiles are added using the corresponding reference number
 * 
 * @see BullpenView
 * @see BullpenController
 * 
 * @author tuckerhaydon
 *
 */

public class Bullpen {

	ArrayList<Integer> tileReferenceNumbers;
	
	public Bullpen(){
		tileReferenceNumbers = new ArrayList<>();
	}
	
	/**
	 * Bullpen Constructor
	 * @param tileRefNums
	 */
	public Bullpen(ArrayList<Integer> tileRefNums){
		this.tileReferenceNumbers = tileRefNums;
	}
	
	/**
	 * sets the reference numbers of the tiles in the bullpen
	 * @param nums
	 */
	public void setTileReferenceNums(ArrayList<Integer> nums){
		this.tileReferenceNumbers = nums;
	}
	
	/**
	 * returns the reference number of all the tiles in the bullpen
	 * @return reference numbers 
	 */
	public ArrayList<Integer> getTileReferenceNumbers(){
		return this.tileReferenceNumbers;
	}
	
	/**
	 * adds a tile to the bullpen and returns if action is successful
	 * @param num - reference number of the tile to be removed
	 * @return 
	 */
	public boolean addTile(Integer num){
		return tileReferenceNumbers.add(num);
	}
	
	/**
	 * removes a tile from the bullpen and returns if action is successful
	 * @param num - reference number of the tile to be removed
	 * @return 
	 */
	public boolean remTile(Integer num){
		return tileReferenceNumbers.remove(num);
	}
	
	/**
	 * returns all the tiles in the bullpen
	 * @return array of tiles
	 */
	public ArrayList<Tile> getTiles(){
		ArrayList<Tile> tiles = new ArrayList<>();
		
		for(Integer i: tileReferenceNumbers){
			tiles.add(new Tile(i, "Bullpen"));
		}
		
		return tiles;
	}
	
	/**
	 * returns whether the bullpen is empty
	 * @return
	 */
	public boolean empty() {
		return tileReferenceNumbers.size() == 0;
	}
}
