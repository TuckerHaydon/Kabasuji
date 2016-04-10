/**
 * 
 */
package builderController;

import builderBoundary.*;
import builderEntity.*;
/**
 * @author kacper
 *
 */
public class AddTileToBullpenMove implements IBuildMove {
	
	KabasujiBuilderApplication app;
	BuilderModel model;

	
	AddTileToBullpenMove(Tile t) {
		
	}
	/* (non-Javadoc)
	 * @see playerController.IMove#doMove(playerBoundary.KabasujiPlayerApplication)
	 */
	@Override
	public boolean doMove(KabasujiBuilderApplication app) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see playerController.IMove#isValid(playerBoundary.KabasujiPlayerApplication)
	 */
	@Override
	public boolean isValid(KabasujiBuilderApplication app) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean undoMove(KabasujiBuilderApplication app) {
		return false;
	}

}
