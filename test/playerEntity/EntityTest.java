/**
 * 
 */
package playerEntity;

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
	Level level;
	LevelAchievementMonitor lam;
	LightningLevel lighteninglevel;
	NumberBoardElt nbe;
	PlayableBoardElt pbe;
	PuzzleAchievementMonitor pam;
	PuzzleLevel puzzlelevel;
	ReleaseAchievementMonitor ram;
	ReleaseLevel releaselevel;
	Square[] squares;
	Tile tile;
	UnplayableBoardElt ubm;
	
	protected void setUp() {
		achievement = new Achievement("TEST");
	}
	
}
