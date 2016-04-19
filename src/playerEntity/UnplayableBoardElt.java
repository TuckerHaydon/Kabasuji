package playerEntity;

/**
 * @author kacper, tuckerhaydon
 *
 */
public class UnplayableBoardElt extends BoardElt {

	int row;
	int col;
	
	public UnplayableBoardElt(int row, int col) {
		super(row, col);
	}
	
	@Override
	public String toString(){
		return "U";
	}
	
}
