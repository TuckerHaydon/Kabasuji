package playerEntity;

import org.junit.Test;

import playerBoundary.KabasujiPlayerApplication;

//NEEDS ASSERT STATEMENTS
public class testLevelParser {

	@Test
	public void testRelease() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		gm.loadLevel("src/resources/levels/release/dorothy1");
		gm.loadLevel("src/resources/levels/release/testLevel");

	}
	
	@Test
	public void testPuzzle() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		gm.loadLevel("src/resources/levels/puzzle/LegalPuzzle");

	}
	
	@Test
	public void testLightning() {
		GameModel gm = GameModel.instance();
		KabasujiPlayerApplication player = new KabasujiPlayerApplication(gm);
		
		gm.loadLevel("src/resources/levels/lightning/Lightning_Level");
	}

}
