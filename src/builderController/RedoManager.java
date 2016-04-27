/**
 * 
 */
package builderController;

import java.util.Stack;

/**
 * This class contains only static members used to manage the 
 * undoing and redoing of moves. The RedoManager implements a stack
 * that is used to store moves that are undone in order to redo
 * moves added to the undone stack
 * <p>
 * Methods in this class include push, pop, peek, get, and clear.
 * @see UndoManager
 * @author kacper puczydlowski
 */
public class RedoManager {
	/**
	 * Moves that are undone and may now be redone
	 */
	static Stack<Move> moves = new Stack<Move>();
	
	static UndoManager redo = null;
	
	/**
	 * Return an instance of the redomanager
	 * @return
	 */
	public static UndoManager instance(){
		if(redo == null) redo = new UndoManager();
		return redo;
	}
	/**
	 * Pushes a Move onto the stack
	 * @param m Move being pushed
	 */
	public static void pushMove(Move m) {
		moves.push(m);
	}
	
	/**
	 * Pops (removes) the top Move off the stack 
	 * @return the top Move
	 */
	public static Move popMove() {
		return moves.pop();
	}
	
	/**
	 * Returns the top Move off the stack without modification
	 * @return an instance of the top Move
	 */
	public static Move peekMove() {
		return moves.peek();
	}
	
	/**
	 * Returns a Move at the specified index
	 * @param index Move being requested
	 * @return Move at index
	 */
	public static Move get(int index) {
		return moves.get(index);
	}
	
	/**
	 * Removes all Moves from the stack
	 */
	public static void clear() {
		moves.removeAllElements();
	}
}
