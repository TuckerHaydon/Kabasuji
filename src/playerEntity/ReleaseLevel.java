package playerEntity;

public class ReleaseLevel extends Level {

	int numEltLeft;
	
	public ReleaseLevel(int levelNum, Board b, Bullpen bp){
		super(levelNum, b, bp);
		// this.numEltLeft = numEltLeft;
	}
	
	void reset(){
		score = 0;
		numEltLeft = 0;		
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
}
