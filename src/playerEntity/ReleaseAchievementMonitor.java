package playerEntity;

import playerController.IMove;

public class ReleaseAchievementMonitor extends LevelAchievementMonitor{
	int numberCovered;
	ReleaseLevel lv;
	
	
	public ReleaseAchievementMonitor(ReleaseLevel lv){
		this.lv=lv;
	}
	
	@Override
	public void updateAchievement(IMove move) {
		// TODO Auto-generated method stub
		
	}
}
