package playerEntity;

import playerController.IMove;

public abstract class LevelAchievementMonitor {
	int moveCounter;
	boolean isillegalMove;
	Achievement[] achievements = new Achievement[10];
	
	public abstract void updateAchievement(IMove move);
}
