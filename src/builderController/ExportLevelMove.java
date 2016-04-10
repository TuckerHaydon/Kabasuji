package builderController;

import builderController.IMove;
import builderEntity.BuilderModel;

public class ExportLevelMove implements IMove {

	BuilderModel model;
	
	ExportLevelMove(BuilderModel m){
		this.model = m;
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