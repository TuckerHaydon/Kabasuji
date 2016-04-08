package playerEntity;

import playerController.IMove;

public class LightningAchievementMonitor extends LevelAchievementMonitor{
	boolean slowpoke;
	boolean speedyGonzale;
	LightningLevel lv;
	
	public LightningAchievementMonitor(LightningLevel lv){
		this.lv=lv;
	}
	
	@Override
	public void updateAchievement(IMove move) {
		// TODO Auto-generated method stub
		
	}
	
}
