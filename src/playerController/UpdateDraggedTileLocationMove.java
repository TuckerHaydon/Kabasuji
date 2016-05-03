package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * Updates the dragged tile's location as the mouse moves
 * @author tuckerhaydon
 *
 */
public class UpdateDraggedTileLocationMove extends Move {
	
	/**
	 * Constructor for the update dragged tile location move
	 * @param app - top level Kabasuji player application
	 * @param m - top level game model
	 */
	public UpdateDraggedTileLocationMove(KabasujiPlayerApplication app, GameModel m) {
		super(app, m);
	}
	
	/**
	 * Update the dragged tile view with the mouse 
	 */
	@Override
	boolean doMove() {
		if(app.getGameWindow().getMousePosition() == null) return false;
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
		return true;
	}

	@Override
	public boolean undo() {
		return false;
	}

}
