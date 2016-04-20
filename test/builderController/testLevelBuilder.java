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


		protected void setUp(){
		
		}
		
		@Test
		public void testCreateLevel() {
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
		BullpenView bpv = lbv.getBullpenView();
		
		
		lbv.updateView("puzzle");
		lbv.updateView("lightning");
		lbv.updateView("release");
		
		
		Level lvl = lbv.getLevel();
		Bullpen bp = lvl.getBullpen();
		Board board = lvl.getBoard();
		
		builder.displayLevelEditorMenu();
		CreateLevelHandler clh = new CreateLevelHandler(builder, builder.getBuilderModel());
	
		BullpenController bpc = new BullpenController(lbv.getBullpenView(), lbv.getBankView());
		bpc.mouseClicked(new MouseEvent(lbv.getBankView(), 0, 0, 0, 10, 10, 0, false));
			
		}
	
	@Test
	public void testCreateGame(){
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication();
		builder.init();
		builder.displayLevelEditor();
		
		LevelEditor le = builder.getLevelEditor();
		LevelBuilderView lbv = le.getLevelBuilderView();
		LevelEditorMenu lem = builder.getLevelEditorMenu();
		GameEditor ge = builder.getGameEditor();
		GameEditorMenu gem = builder.getGameEditorMenu();
		MainMenu mm = builder.getMainMenu();
		BullpenView bpv = lbv.getBullpenView();
		
		
		lbv.updateView("puzzle");
		lbv.updateView("lightning");
		lbv.updateView("release");
		
		Level lvl = lbv.getLevel();
		Bullpen bp = lvl.getBullpen();
		Board board = lvl.getBoard();
		
		ActionEvent me3 = new ActionEvent(mm, 0, null);
		NavigateGameEditorMenu ngem = new NavigateGameEditorMenu(builder);
		ngem.actionPerformed(me3);
		
		ActionEvent me4 = new ActionEvent(gem, 0, null);
		CreateGameHandler cgh = new CreateGameHandler(builder, builder.getBuilderModel());
		cgh.actionPerformed(me4);
		
		AddLevelToGameMove altgm = new AddLevelToGameMove(builder.getBuilderModel(), 1);
		altgm.setLevelName("Release");
		altgm.doMove();
		altgm.undoMove();
		
		ExportGameMove egm = new ExportGameMove(builder.getBuilderModel(), "testgame");
		egm.doMove();
		egm.undoMove();
	}



}
