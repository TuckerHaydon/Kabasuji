package playerEntity;

/**
 * 
 * @author tuckerhaydon, dorothy
 *
 */
public class ReleaseLevel extends Level {

	int numEltLeft;
	
	public ReleaseLevel(int levelNum, Board b, Bullpen bp){
		super(levelNum, b, bp);
		// this.numEltLeft = numEltLeft;
	}
	
	public void reset(){
		System.out.println("release level reset");
		score = 0;
		numEltLeft = 0;		
	}
	
	public int getNumLeft() {
		return this.numEltLeft;
	}
	/*added by Dorothy*/
	public void decrementNumElt(){
		this.numEltLeft--;
	}
	
	public boolean isCoverAll(){
		return this.numEltLeft==0;
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param i
	 */
	public void setNumLeft(int i) {
		this.numEltLeft = i;
	}
}
