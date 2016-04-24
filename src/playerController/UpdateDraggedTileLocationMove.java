package playerController;

import playerBoundary.KabasujiPlayerApplication;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class UpdateDraggedTileLocationMove implements IMove {

	@Override
	public boolean doMove(KabasujiPlayerApplication app) {
		
		if(!this.isValid(app)){
			return false;
		}
		
		double mouseLocationX = app.getGameWindow().getMousePosition().getX();
		double mouseLocationY = app.getGameWindow().getMousePosition().getY();
		
		int centerLocationX = (int)(mouseLocationX - 3.5*app.getGameWindow().getDraggedTile().getSquareWidth());
		int centerLocationY = (int)(mouseLocationY - 3*app.getGameWindow().getDraggedTile().getSquareWidth());
				
		app.getGameWindow().getDraggedTile().setLocation(centerLocationX, centerLocationY);
		app.getGameWindow().displayDraggedTile();
		return false;
	}

	@Override
	public boolean isValid(KabasujiPlayerApplication app) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean undo(KabasujiPlayerApplication app) {
		// Not an undoable move
		return false;
	}

}
