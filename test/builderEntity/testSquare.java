/**
 * 
 */
package builderEntity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author kacper
 *
 */
public class testSquare {
	
	@Test
	public void test() {
		Tile t = new Tile(0,"bullpen");
		Square s = t.getSquares()[0];
		
		s.setX(1);
		assertEquals(1,s.getAnchorRelX());
		s.setY(1);
		assertEquals(1,s.getAnchorRelY());
		Tile t2 = new Tile(0,"board");
		s.setOwner(t2);
		s.setTile(t2);
		assertEquals(s.getOwner(),t2);
	}

}
