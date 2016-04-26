package playerEntity;

import java.awt.Color;

/**
 * @author kacper, tuckerhaydon
 *
 */
public class NumberedBoardElt extends PlayableBoardElt {

	int row;
	int col;
	boolean isHint;
	int number;
	Color color;
	
	public NumberedBoardElt(int row, int col, boolean isHint, Color color, int num) {
		super(row, col, isHint);
		this.color = color;
		this.number = num;
	}
	
	
	public void setCovered(boolean b) {
		this.isCovered = b;
	}
	
	public boolean getCovered() {
		return this.isCovered;
	}
	public void toggleCovered() {
		isCovered = !isCovered;
	}
	
	public void toggleHint() {
		isHint = !isHint;
	}
	
	public boolean isHint(){
		return isHint;
	}
	
	@Override
	public String toString(){
		if(isHint){
			return "NH";
		}
		else{
			return "N";
		}
	}
	
	public int getNum(){
		return number;
	}
	
	public Color getColor(){
		return color;
	}
	
}
