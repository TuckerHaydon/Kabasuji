package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * sets the boardElt color in the builder application
 * @author tuckerhaydon
 *
 */
public class SetBoardEltColorMove extends Move {

	String color;
	String prev;
	
	/**
	 * constructor for setBoardEltColorMove
	 * @param app
	 * @param m
	 * @param color
	 */
	SetBoardEltColorMove(KabasujiBuilderApplication app, BuilderModel m, String color){
		super(app, m);
		this.color = color;
	}
	
	@Override
	boolean doMove() {
		prev = m.getSelectedColor();
		m.setSelectedColor(color);
		return true;
	}

	@Override
	public boolean undoMove() {
		
		m.setSelectedColor(prev);
		return true;
	}

	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
