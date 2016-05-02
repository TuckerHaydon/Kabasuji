package playerEntity;

/**
 * Playable Board Element
 * This Board element is one that can be covered by a Tile,
 * be specified as part of a hint, and exists a defined row and column
 * @author kacper, tuckerhaydon
 *
 */
public class PlayableBoardElt extends BoardElt {
	int row;
	int col;
	boolean isCovered;
	boolean isHint;
	
	public PlayableBoardElt(int row, int col, boolean isHint){
		super(row, col);
		this.isHint = isHint;
		this.isCovered = false;
	}
	
	/**
	 * Covers an BoardElt
	 * @param b whether or not the BoardElt is covered
	 */
	public void setCovered(boolean b) {
		this.isCovered = b;
	}
	
	/**
	 * Returns whether or not a BoardElt is covered
	 * @return
	 */
	public boolean getCovered() {
		return this.isCovered;
	}
	
	/**
	 * Returns if this BoardElt is a hint
	 * @return if isHint
	 */
	public boolean isHint(){
		return isHint;
	}
	
	@Override
	public String toString(){
		if(isHint){
			return "PH";
		}
		else{
			return "P";
		}
	}
	
}
