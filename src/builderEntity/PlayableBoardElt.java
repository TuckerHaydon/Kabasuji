package builderEntity;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class PlayableBoardElt extends BoardElt{

	boolean isHint;
	
	public PlayableBoardElt(int row, int col, boolean isHint) {
		super(row, col);
		this.isHint = isHint;
		// TODO Auto-generated constructor stub
	}
	
	void setIsHint(boolean h){
		this.isHint = h;
	}
	
	public boolean isHint(){
		return this.isHint;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
