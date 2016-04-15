package builderEntity;

public class UnplayableBoardElt extends BoardElt{

	UnplayableBoardElt(int row, int col) {
		super(row, col);
		
	}

	@Override
	public String toString() {
		return "U";
	}

}
