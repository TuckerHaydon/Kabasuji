package builderEntity;

/**
 * 
 * Playable Board Element Class
 * This Board element is one that can be specified to be played on,
 * and be a part of a hint. 
 * @see BoardElt
 * 
 * @author tuckerhaydon
 *
 */
public class PlayableBoardElt extends BoardElt{

	boolean isHint;
	
	public PlayableBoardElt(int row, int col, boolean isHint) {
		super(row, col);
		this.isHint = isHint;
	}
	
	/***
	 * sets the BoardElt as a hint
	 * @param h
	 */
	void setIsHint(boolean h){
		this.isHint = h;
	}
	
	/**
	 * returns whether the BoardElt is a hint
	 * @return 
	 */
	public boolean isHint(){
		return this.isHint;
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
	
	/**
	 * returns the type of BoardElt as a string
	 */
	public String getType() {
		return "playable";
	}
	
	@Override
	public boolean equals(Object other){
		if(other == null){
			return false;
		}
		
		if(!(other instanceof PlayableBoardElt)){
			return false;
		}
		
		PlayableBoardElt elt = (PlayableBoardElt)other;
		
		return (this.row == elt.row) && (this.col == elt.col) && (this.isHint == elt.isHint);
	}

}
