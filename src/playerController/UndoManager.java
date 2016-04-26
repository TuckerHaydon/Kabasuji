/**
 * 
 */
package playerController;

import java.util.Stack;

/**
 * This class contains only static members used to manage the 
 * undoing and redoing of moves. The UndoManager implements a stack
 * that is used to store moves as they are completed in the game
 * <p>
 * Methods in this class include push, pop, peek, get, and clear.
 * @author kacper puczydlowski
 */
public class UndoManager {
	static Stack<Move> moves = new Stack<Move>();
	
	/**
	 * Pushes a Move onto the stack
	 * @param m Move being pushed
	 */
	public static void pushMove(Move m) {
		moves.push(m);
	}
	
	/**
	 * Pops (removes) a move from the stack
	 * @return
	 */
	public static Move popMove() {
		return moves.pop();
	}
	
	/**
	 * Returns the top Move off the stack without modification
	 * @return
	 */
	public static Move peekMove() {
		return moves.peek();
	}
	
	/**
	 * REturns a Move at the specified index
	 * @param index index of requested Move	
	 * @return a Move
	 */
	public static Move get(int index) {
		return moves.get(index);
	}
	
	/**
	 * Remove all elements from the stack
	 */
	public static void clear() {
		moves.removeAllElements();
	}
}
