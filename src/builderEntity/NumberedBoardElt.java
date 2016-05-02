package builderEntity;

import java.awt.Color;

/**
 * 
 * Numbered Board Element
 * This is a Playable Element which contains a specified color and number.
 * This is used in Release Levels
 * @see PlayableBoardElt
 * @see BoardElt
 * 
 * @author tuckerhaydon
 *
 */
public class NumberedBoardElt extends PlayableBoardElt{

	Color c;
	int num;
	public NumberedBoardElt(int row, int col, boolean isHint, Color c, int num) {
		super(row, col, isHint);
		this.c = c;
		this.num = num;	
	}
	
	/**
	 * sets the color of the board elt to the given param
	 * @param c
	 */
	void setColor(Color c){
		this.c = c;
	}
	
	/**
	 * returns the color of the BoardElt
	 * @return color of board elt
	 */
	public Color getColor(){
		return this.c;
	}
	
	/**
	 * returns the color of the BoardElt as a String
	 * @return color of board elt
	 */
	public String getColorString() {
		return c.toString();
	}
	
	/**
	 * sets the number which will be associated with this 
	 * board elt
	 * @param n
	 */
	void setNum(int n){
		this.num = n;
	}
	
	/**
	 * returns the number associated with this board elt
	 * @return
	 */
	public int getNum(){
		return this.num;

	}
	
	/**
	 * returns the type of the board elt as a string
	 */
	public String getType() {
		return "numbered";
	}
	
	@Override
	public String toString(){
		if(c.equals(Color.RED)){
			return "N"+num + "R";
		}
		else if(c.equals(Color.BLUE)){
			return "N"+num + "B";
		}
		else {
			return "N"+num + "G";
		}
	}

}
