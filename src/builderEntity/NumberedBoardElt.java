package builderEntity;

import java.awt.Color;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class NumberedBoardElt extends PlayableBoardElt{

	Color c;
	int num;
	public NumberedBoardElt(int row, int col, boolean isHint, Color c, int num) {
		super(row, col, isHint);
		this.c = c;
		this.num = num;
		
	}
	
	void setColor(Color c){
		this.c = c;
	}
	
	public Color getColor(){
		return this.c;
	}
	
	void setNum(int n){
		this.num = n;
	}
	
	public int getNum(){
		return this.num;

	}
	
	@Override
	public String toString(){
		if(c.equals(Color.RED)){
			return "N"+num + "R";
		}
		else if(c.equals(Color.BLUE)){
			return "N"+num + "B";
		}
		else {
			return "N"+num + "G";
		}
	}

}
