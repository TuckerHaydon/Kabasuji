/**
 * 
 */
package playerEntity;

import java.awt.Color;

/**
 * @author kacper
 *
 */
public class NumberBoardElt extends PlayableBoardElt {

	int row;
	int col;
	int isHint;
	int number;
	Color color;
	
	public NumberBoardElt(int row, int col, boolean isHint, Color color, int num) {
		super(row, col, isHint);
		this.color = color;
		this.number = num;
	}
}
