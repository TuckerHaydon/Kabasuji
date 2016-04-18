package builderController;


import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Test;

import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.LevelBuilderView;
import builderBoundary.LevelEditor;
import builderBoundary.LevelEditorMenu;
import builderBoundary.View;
import builderEntity.Board;
import builderEntity.Bullpen;
import builderEntity.Level;



public class testLevelBuilder {

	@Test
	
		public void setUp() {
			KabasujiBuilderApplication builder = new KabasujiBuilderApplication();
			builder.init();
			builder.displayLevelEditor();
			LevelEditor le = builder.getLevelEditor();
			LevelBuilderView lbv = le.getLevelBuilderView();
			LevelEditorMenu lem = builder.getLevelEditorMenu();
			lbv.updateView("puzzle");
			lbv.updateView("lightning");
			lbv.updateView("release");
			Level lvl = lbv.getLevel();
			Bullpen bp = lvl.getBullpen();
			Board board = lvl.getBoard();
			builder.displayLevelEditorMenu();
			ActionEvent me = new ActionEvent(lem, 0, null);

			CreateLevelHandler clh = new CreateLevelHandler(builder, builder.getBuilderModel());
			clh.actionPerformed(me);
			new SetLevelTypeMove(lvl, "puzzle", lbv);
	
		}
	
	protected void tearDown(){
	
	}
	
	public void test(){
	//	LevelEditor le = builder.levelEditor;
	}



}
