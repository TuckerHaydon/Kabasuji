package playerController;

import java.util.Hashtable;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Achievement;
import playerEntity.GameModel;

/**
 * Set all the achievements to the status of "Not earned"
 * @author dorothy
 *
 */
public class ResetAchievementMove extends Move{
	Hashtable<String, Achievement> achievements;
	boolean[] isReset;
	
	public ResetAchievementMove(KabasujiPlayerApplication app, GameModel m, Hashtable<String, Achievement> achievements){
		super(app, m);
		this.achievements=achievements;
		isReset = new boolean[11];
	}
	
	/**
	 * Reset all of the achievements
	 */
	@Override
	boolean doMove() {
		
		
		for(String key: achievements.keySet()){
			this.achievements.get(key).reset();
		}
		return true;
	}
	
	@Override
	boolean isValid() {
		if(!achievements.isEmpty()){
			return true;
		}
		return false;
	}
	
	/**
	 * You can undo ResetAchievementMove
	 */
	@Override
	public boolean undo() {
		return false;
	}
}
