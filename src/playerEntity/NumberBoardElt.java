/**
 * 
 */
package playerEntity;

/**
 * @author kacper
 *
 */
public class NumberBoardElt extends PlayableBoardElt {

	int row;
	int col;
	int isHint;
	int number;
	String color;
	public NumberBoardElt(int row, int col, boolean isHint, String color) {
		super(row, col, isHint);
		this.color = color;
	}

}
