
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
	
	public PlayableBoardElt(int row, int col, boolean isHint){
		super(row, col);
		this.isHint = isHint;
		this.isCovered = false;
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
			return "PH";
		}
		else{
			return "P";
		}
	}
	
}
