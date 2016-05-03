package playerEntity;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;

//NEEDS ASSERT STATEMENTS
public class testLevelParser {

	@Test
	public void testRelease() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
//		gm.loadLevel("src/resources/levels/release/dorothy1");
		gm.loadLevel("src/resources/levels/release/Level 3"
				+ ""
				+ "");

	}
	
	@Test
	public void testPuzzle() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		gm.loadLevel("src/resources/levels/puzzle/Level 1");

	}
	
	@Test
	public void testLightning() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		gm.loadLevel("src/resources/levels/lightning/Level 2");
	}

}
