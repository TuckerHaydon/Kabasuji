package builderEntity;

public class UnplayableBoardElt extends BoardElt{

	public UnplayableBoardElt(int row, int col) {
		super(row, col);
		
	}

	@Override
	public String toString() {
		return "U";
	}

}
