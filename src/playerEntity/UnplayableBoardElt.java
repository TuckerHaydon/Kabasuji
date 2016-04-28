package playerEntity;

/**
 * Unplayable Board Element
 * This type of Board Element is one on which a 
 * Tile cannot be placed
 * @author kacper puczydlowski, tuckerhaydon
 *
 */
public class UnplayableBoardElt extends BoardElt {

	int row;
	int col;
	
	/**
	 * BoardElt constructor
	 * @param row
	 * @param col
	 */
	public UnplayableBoardElt(int row, int col) {
		super(row, col);
	}
	
	@Override
	public String toString(){
		return "U";
	}
	
}
