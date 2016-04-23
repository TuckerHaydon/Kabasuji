package playerEntity;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class LightningLevel extends Level{

	int allowedTime;
	int usedTime;
	javax.swing.Timer timer;
	
	public LightningLevel(int levelNum, int allowedTime, Board b, Bullpen bp) {
		super(levelNum, b, bp);
		this.allowedTime = allowedTime;
	}
	
	int getAllowedTime() {
		return this.allowedTime;
	}
	
	public int getUsedTime() {
		return this.usedTime;
	}
	void updateTime(int delta){
		usedTime += delta;
	}
	
	public void reset(){
		System.out.println("Lighting level reset");
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

	/**
	 * @param i
	 */
	public void setUsedTime(int i) {
		usedTime = i;
	}
	
	@Override
	public String toString(){
		return "Lightning";
	}
}
