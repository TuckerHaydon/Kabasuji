package builderController;

public interface IMove {
	boolean doMove();
	boolean undoMove();
	boolean isValid();
}
