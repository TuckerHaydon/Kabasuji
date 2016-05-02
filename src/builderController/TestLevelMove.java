package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * A controller object that permits that testing of a built level. The move greates a new GameModel
 * @author tuckerhaydon
 *
 */
public class TestLevelMove extends Move{
	
	public TestLevelMove(KabasujiBuilderApplication app, BuilderModel m) {
		super(app, m);
	}

	@Override
	boolean doMove() {
		
		// Export the current level to a test file
		ExportLevelMove move = new ExportLevelMove(app, m, "test_level", true);
		move.execute();
		
		// Launch the player application 
		GameModel gameModel =  GameModel.instance();
		KabasujiPlayerApplication playerApp = new KabasujiPlayerApplication(gameModel, "src/resources/levels/test/test_level",app);
		playerApp.getGameModel().setIsTesting(true);
		app.getLevelEditor().setVisible(false);
		return true;
	}

	@Override
	boolean isValid() {
		// Can always test a level
		return true;
	}

	@Override
	public boolean undoMove() {
		// Cannot undo a test
		return false;
	}

}
