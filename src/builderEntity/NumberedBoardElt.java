package builderEntity;

import java.awt.Color;

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
	
	Color getColor(){
		return this.c;
	}
	
	void setNum(int n){
		this.num = n;
	}
	
	int getNum(){
		return this.num;
	}

}
