package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class UpdateDraggedTileLocationMove extends Move {
	
	public UpdateDraggedTileLocationMove(KabasujiPlayerApplication app, GameModel m) {
		super(app, m);
	}

	@Override
	boolean doMove() {
		
		double mouseLocationX = app.getGameWindow().getMousePosition().getX();
		double mouseLocationY = app.getGameWindow().getMousePosition().getY();
		
		int centerLocationX = (int)(mouseLocationX - 3.5*app.getGameWindow().getDraggedTile().getSquareWidth());
		int centerLocationY = (int)(mouseLocationY - 3*app.getGameWindow().getDraggedTile().getSquareWidth());
				
		app.getGameWindow().getDraggedTile().setLocation(centerLocationX, centerLocationY);
		app.getGameWindow().displayDraggedTile();
		return false;
	}

	@Override
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean undo() {
		// Not an undoable move
		return false;
	}

}
