package playerEntity;

import playerController.IMove;

public class PuzzleAchievementMonitor extends LevelAchievementMonitor{
	int toBullpenMove;
	PuzzleLevel lv;
	
	public PuzzleAchievementMonitor(PuzzleLevel lv){
		this.lv=lv;
	}
	
	@Override
	public boolean updateAchievement(IMove move) {
		boolean somethingnew = false;
		return somethingnew;
	}
	
}
