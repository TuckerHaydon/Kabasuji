package builderController;

import java.awt.Color;

import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class SetBoardEltColorMove extends Move {

	BuilderModel model;
	String color;
	String prev;
	
	SetBoardEltColorMove(BuilderModel m, String color){
		super(m);
		this.model = m;
		this.color = color;
	}
	
	@Override
	public boolean doMove() {
		prev = model.getSelectedColor();
		model.setSelectedColor(color);
		return true;
	}

	@Override
	public boolean undoMove() {
		
		model.setSelectedColor(prev);
		return true;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
