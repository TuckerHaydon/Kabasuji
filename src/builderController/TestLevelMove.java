package builderController;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class TestLevelMove implements IMove{
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	public TestLevelMove(KabasujiBuilderApplication app, BuilderModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public boolean doMove() {
		
		// Validate the move
		if(!this.isValid()){
			return false;
		}
		
		System.out.println(m.getLevel().getBoard());
		
		// Export the current level to a test file
		ExportLevelMove move = new ExportLevelMove(m, "test_level", true);
		move.doMove();
		
		// Launch the player application 
		GameModel gameModel = new GameModel();
		KabasujiPlayerApplication playerApp = new KabasujiPlayerApplication(gameModel, "src/resources/levels/test/test_level");

		return false;
	}

	@Override
	public boolean isValid() {
		// Can always test a level
		return true;
	}

	@Override
	public boolean undoMove() {
		// Cannot undo a test
		return false;
	}

}
