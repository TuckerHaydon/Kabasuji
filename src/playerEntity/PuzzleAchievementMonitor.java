package playerEntity;

import playerController.IMove;

public class PuzzleAchievementMonitor extends LevelAchievementMonitor{
	int toBullpenMove;
	PuzzleLevel lv;
	
	public PuzzleAchievementMonitor(PuzzleLevel lv){
		this.lv=lv;
	}
	
	@Override
	public void updateAchievement(IMove move) {
		// TODO Auto-generated method stub
		
	}
	
}
