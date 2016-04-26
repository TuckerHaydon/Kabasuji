package playerEntity;

import java.awt.Color;

/**
 * Numbered Board Element
 * This extension of a Playable Element contains a specified color and number
 * This is used in Release Levels
 * @author kacper puczydlowski, tuckerhaydon
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
	
	@Override
	public String toString(){
		if(isHint){
			return "NH";
		}
		else{
			return "N";
		}
	}
	
	/**
	 * Returns the number of the Element
	 * @return number of element
	 */
	public int getNum(){
		return number;
	}
	
	/**
	 * Returns the Color of the Element
	 * @return color of element
	 */
	public Color getColor(){
		return color;
	}
	
}
