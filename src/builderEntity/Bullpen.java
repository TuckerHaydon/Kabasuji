package builderEntity;

import java.util.ArrayList;

public class Bullpen {

	ArrayList<Integer> tileReferenceNumbers;
	
	public Bullpen(){
		tileReferenceNumbers = new ArrayList<>();
		
		// TODO remove this. For debugging purposes only.
//		for(int i = 1; i < 36; i++){
//			this.addTile(i);
//		}
	}
	
	public Bullpen(ArrayList<Integer> tileRefNums){
		this.tileReferenceNumbers = tileRefNums;
	}
	
	public void setTileReferenceNums(ArrayList<Integer> nums){
		this.tileReferenceNumbers = nums;
	}
	
	public ArrayList<Integer> getTileReferenceNumbers(){
		return this.tileReferenceNumbers;
	}
	
	public boolean addTile(Integer num){
		return tileReferenceNumbers.add(num);
	}
	
	public boolean remTile(Integer num){
		return tileReferenceNumbers.remove(num);
	}
	
	public ArrayList<Tile> getTiles(){
		ArrayList<Tile> tiles = new ArrayList<>();
		
		for(Integer i: tileReferenceNumbers){
			tiles.add(new Tile(i, "Bullpen"));
		}
		
		return tiles;
	}
	
}
