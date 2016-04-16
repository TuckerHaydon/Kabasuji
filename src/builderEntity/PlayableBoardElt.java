package builderEntity;

public class PlayableBoardElt extends BoardElt{

	boolean isHint;
	
	public PlayableBoardElt(int row, int col, boolean isHint) {
		super(row, col);
		this.isHint = isHint;
	}
	
	void setIsHint(boolean h){
		this.isHint = h;
	}
	
	public boolean isHint(){
		return this.isHint;
	}

	@Override
	public String toString() {
		
		if(isHint){
			return "PH";
		}
		else{
			return "P";
		}
	}

}
