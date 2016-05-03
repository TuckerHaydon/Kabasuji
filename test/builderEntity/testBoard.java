/**
 * 
 */
package builderEntity;

import static org.junit.Assert.*;

import org.junit.Test;

import builderBoundary.KabasujiBuilderApplication;

/**
 * @author kacper
 *
 */
public class testBoard {
	@Test
	public void test(){
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication(m);
		builder.init();
		Board board = m.getLevel().getBoard();
		
		Board e = new Board(board.getBoardElts());
		
		e.setElts(board.getElts());
		assertEquals(board.getElts()[1][1],e.getBoardElts()[1][1]);
		board.resetAfterRelease();
		assertEquals(board.getElts()[1][1],e.getBoardElts()[1][1]);
		
	}
	
}
