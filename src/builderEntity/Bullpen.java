package builderEntity;

import java.util.ArrayList;

public class Bullpen {

	ArrayList<Integer> tileReferenceNumbers;
	
	public Bullpen(){
		tileReferenceNumbers = new ArrayList<>();
	}
	
	public Bullpen(ArrayList<Integer> tileRefNums){
		this.tileReferenceNumbers = tileRefNums;
	}
	
	public void setTiles(ArrayList<Integer> nums){
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
	
}
