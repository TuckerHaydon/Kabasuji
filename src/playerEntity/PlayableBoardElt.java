/**
 * 
 */
package playerEntity;

/**
 * @author kacper
 *
 */
public class PlayableBoardElt extends BoardElt {
	int row;
	int col;
	boolean isCovered;
	boolean isHint;
	
	PlayableBoardElt(int row, int col, boolean isHint){
		super(row, col);
		this.isHint = isHint;
		this.isCovered = false;
	}
	
	void setCovered(boolean b) {
		this.isCovered = b;
	}
	
	void toggleCovered() {
		isCovered = !isCovered;
	}
	
	void toggleHint() {
		isHint = !isHint;
	}
}
