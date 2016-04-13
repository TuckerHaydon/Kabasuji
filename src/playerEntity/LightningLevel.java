package playerEntity;

public class LightningLevel extends Level{

	int allowedTime;
	int usedTime;
	javax.swing.Timer timer;
	
	public LightningLevel(int levelNum, int allowedTime, Board b, Bullpen bp) {
		super(levelNum, b, bp);
		this.allowedTime = allowedTime;
	}
	
	void updateTime(int delta){
		usedTime += delta;
	}
	
	void reset(){
		score = 0;
		usedTime = 0;
	}

	public boolean isTimeUsedUp(){
		return (this.allowedTime==this.usedTime);
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}
}
