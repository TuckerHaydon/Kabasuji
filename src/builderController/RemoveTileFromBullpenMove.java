package builderController;

import builderEntity.BuilderModel;
import builderEntity.Bullpen;
import builderEntity.Tile;

public class RemoveTileFromBullpenMove implements IMove{

	Tile t;
	Bullpen bp;
	
	RemoveTileFromBullpenMove(Tile t, Bullpen bp){
		this.t = t;
		this.bp = bp;
	}
	
	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
