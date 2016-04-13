/**
 * 
 */
package playerEntity;

import java.util.ArrayList;
import java.util.LinkedList;

import junit.framework.TestCase;

/**
 * @author kacper
 *
 */
public class EntityTest extends TestCase {
	
	Achievement achievement;
	Anchor anchor;
	Board board;
	BoardElt boardelt;
	Bullpen bullpen;
	GameAchievementMonitor gam;
	GameModel model;
	LightningAchievementMonitor lam;
	LightningLevel lightninglevel;
	NumberBoardElt nbe;
	PlayableBoardElt pbe;
	PuzzleAchievementMonitor pam;
	PuzzleLevel puzzlelevel;
	ReleaseAchievementMonitor ram;
	ReleaseLevel releaselevel;
	Square square;
	Tile tile;
	UnplayableBoardElt ube;
	
	protected void setUp() {
		achievement = new Achievement("TEST");
		int coords[][] = new int[6][2];
		coords[0][0] = 0;
		coords[0][1] = 0;
		coords[1][0] = 1;
		coords[1][1] = 1;
		coords[2][0] = 0;
		coords[2][1] = 1;
		coords[3][0] = 0;
		coords[3][1] = -1;
		coords[4][0] = -1;
		coords[4][1] = -1;
		coords[5][0] = 1;
		coords[5][1] = 0;
		
		tile = new Tile(coords, "Sample");
		square = new Square(1,1,tile);
		anchor = new Anchor(0,0,tile);
		nbe = new NumberBoardElt(0,0, true, "red");
		pbe = new PlayableBoardElt(0,1, false);
		ube = new UnplayableBoardElt(0,2);
		board = new Board();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles.add(tile);
		bullpen = new Bullpen(tiles);
		puzzlelevel = new PuzzleLevel(1, 1);
		lightninglevel = new LightningLevel(2, 2);
		releaselevel = new ReleaseLevel(3, 1);
		LinkedList<Level> levels = new LinkedList<Level>();
		levels.add(puzzlelevel);
		levels.add(lightninglevel);
		levels.add(releaselevel);
		//pam = new PuzzleAchievementMonitor();
		//lam = new LightningAchievementMonitor(lightninglevel);
		gam = new GameAchievementMonitor(levels);
		
		
		
	}
	protected void tearDown() {
		
	}
	
	void testAchievement() {
		
	}
	
}
