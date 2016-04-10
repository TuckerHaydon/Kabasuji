package builderEntity;

import com.sun.prism.paint.Color;

public class NumberedBoardElt extends PlayableBoardElt{

	Color c;
	int num;
	NumberedBoardElt(int row, int col, boolean isHint, Color c, int num) {
		super(row, col, isHint);
		this.c = c;
		this.num = num;
		
	}

}
