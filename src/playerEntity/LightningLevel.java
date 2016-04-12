package playerEntity;

public class LightningLevel extends Level{

	int allowedTime;
	int usedTime;
	javax.swing.Timer timer;
	
	Bullpen bullpen;
	Board board;
	
	public LightningLevel(int levelNum, int allowedTime) {
		super(levelNum);
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
