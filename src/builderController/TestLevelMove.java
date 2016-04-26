package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

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
		app.getLevelEditor().setVisible(false);
		return false;
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
