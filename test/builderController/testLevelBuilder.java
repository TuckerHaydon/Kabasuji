package builderController;


import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Test;

import builderBoundary.BullpenView;
import builderBoundary.GameEditor;
import builderBoundary.GameEditorMenu;
import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.LevelBuilderView;
import builderBoundary.LevelEditor;
import builderBoundary.LevelEditorMenu;
import builderBoundary.MainMenu;
import builderBoundary.View;
import builderEntity.Board;
import builderEntity.Bullpen;
import builderEntity.Level;



public class testLevelBuilder {

	@Test
	
		public void setUp() {
			KabasujiBuilderApplication builder = new KabasujiBuilderApplication();
			builder.init();
			builder.displaySplashScreen();
			builder.displayLevelEditor();
			
			LevelEditor le = builder.getLevelEditor();
			LevelBuilderView lbv = le.getLevelBuilderView();
			LevelEditorMenu lem = builder.getLevelEditorMenu();
			GameEditor ge = builder.getGameEditor();
			GameEditorMenu gem = builder.getGameEditorMenu();
			MainMenu mm = builder.getMainMenu();
			
			
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
			
			ActionEvent me1A = new ActionEvent(lem, 0, null); 
			BullpenController bpc = new BullpenController(lbv.getBullpenView(), lbv.getBankView());
			bpc.mouseClicked(new MouseEvent(lbv.getBankView(), 0, 0, 0, 10, 10, 0, false));
			
			
			ActionEvent me2 = new ActionEvent(lem, 0, null);
			NavigateMainMenu nmm = new NavigateMainMenu(builder);
			nmm.actionPerformed(me2);
			
			ActionEvent me3 = new ActionEvent(mm, 0, null);
			NavigateGameEditorMenu ngem = new NavigateGameEditorMenu(builder);
			ngem.actionPerformed(me3);
			
			ActionEvent me4 = new ActionEvent(gem, 0, null);
			CreateGameHandler cgh = new CreateGameHandler(builder, builder.getBuilderModel());
			cgh.actionPerformed(me4);
			
			ActionEvent me5 = new ActionEvent(ge, 0, null);
			AddLevelToGameHandler altgh = new AddLevelToGameHandler(builder.getBuilderModel(), 1);
			altgh.actionPerformed(me5);
			
			ActionEvent me6 = new ActionEvent(ge, 0, null);
			AddLevelToGameHandler altgh2 = new AddLevelToGameHandler(builder.getBuilderModel(), 3);
			altgh2.actionPerformed(me6);
			
			ActionEvent me7 = new ActionEvent(ge, 0, null);
			ExportGameHandler egh = new ExportGameHandler(builder.getBuilderModel());
			egh.actionPerformed(me7);
			
		}
	
	protected void tearDown(){
	
	}
	
	public void test(){
	//	LevelEditor le = builder.levelEditor;
	}



}
