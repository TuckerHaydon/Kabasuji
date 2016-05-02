package builderEntity;

/**
 * UnplayableBoardElt
 * 
 * This type of Board Element is one on which a Tile cannot 
 * be placed.
 * 
 * @see BoardElt
 * 
 * @author tuckerhaydon
 *
 */
public class UnplayableBoardElt extends BoardElt{

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
	
	/**
	 * @return - the type of BoardElt as a string
	 */
	public String getType() {
		return "unplayable";
	}

}
