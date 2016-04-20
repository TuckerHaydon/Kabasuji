package builderController;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Test;

import builderBoundary.BankView;
import builderBoundary.BoardView;
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
import builderEntity.BuilderModel;
import builderEntity.Bullpen;
import builderEntity.Level;
import builderEntity.Square;
import builderEntity.Tile;



public class testLevelBuilder {


		protected void setUp(){
		
		}
		
		@Test
		public void testCreateLevel() {
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication();
		builder.init();
		builder.displaySplashScreen();
		builder.displayLevelEditor();
		
		BuilderModel bm = builder.getBuilderModel();
		LevelEditor le = builder.getLevelEditor();
		LevelBuilderView lbv = le.getLevelBuilderView();
		LevelEditorMenu lem = builder.getLevelEditorMenu();
		GameEditor ge = builder.getGameEditor();
		GameEditorMenu gem = builder.getGameEditorMenu();
		MainMenu mm = builder.getMainMenu();
		BullpenView bpv = lbv.getBullpenView();
		BoardView bv = lbv.getBoardView();
		BankView bankview = lbv.getBankView();
		
		
		lbv.updateView("puzzle");
		lbv.updateView("lightning");
		lbv.updateView("release");
		
		
		Level lvl = lbv.getLevel();
		Bullpen bp = lvl.getBullpen();
		Board board = lvl.getBoard();
		
		builder.displayLevelEditorMenu();
		CreateLevelHandler clh = new CreateLevelHandler(builder,bm);
	
		BullpenController bpc = new BullpenController(bpv, bankview);
		BoardController boardc = new BoardController(bv, bm);
		BankController bkc = new BankController(bankview, bpv);
		
		Graphics bankg = bankview.getGraphics();
		Tile tile1 = new Tile(1, "bullpen");
		Tile tile2 = new Tile(2, "bullpen");
		
		MouseEvent meBank = new MouseEvent(bankview, 0, 0, 0, 0, 20, 20, false);
		bkc.mouseClicked(meBank);
		
		MouseEvent meBoard = new MouseEvent(bankview, 0, 0, 0, 0, 20, 20, false);
		boardc.mousePressed(meBoard);
		
		MouseEvent meBullpen = new MouseEvent(bankview, 0, 0, 0, 0, 20, 20, false);
		bpc.mouseClicked(meBullpen);
		
		AddTileToBullpenMove attbpm = new AddTileToBullpenMove(tile1, bpv);
		attbpm.doMove();
		
		Graphics g = bpv.getGraphics();
		bpv.paintComponent(g);
		
		AddTileToBullpenMove attbpm2 = new AddTileToBullpenMove(tile2, bpv);
		attbpm2.doMove();
		attbpm2.undoMove();
		
		SetLevelTypeMove sltm = new SetLevelTypeMove(lvl, "release", lbv);
		sltm.doMove();
		
		bm.setSelectedBoardEltType("numbered");
		bm.setSelectedColor("green");
		ChangeBoardEltMove cbem = new ChangeBoardEltMove(bm, board, 1, 1);
		cbem.doMove();
		cbem.undoMove();
		bm.setSelectedColor("red");
		cbem.doMove();
		cbem.undoMove();
		bm.setSelectedColor("blue");
		cbem.doMove();
		
		bm.setLevel(lvl);
		bm.setSelectedNumber(2);
		bm.isHintSelected();
		bm.getTileBank();
		bm.setHintSelected(true);
		String bmstring = bm.toString();
		bm.setSelectedBoardEltType("playable");
		ChangeBoardEltMove cbem2 = new ChangeBoardEltMove(bm, board, 1, 2);
		cbem2.doMove();
		
		
		bm.setSelectedBoardEltType("unplayable");
		ChangeBoardEltMove cbem3 = new ChangeBoardEltMove(bm, board, 1, 3);
		cbem3.doMove();
		cbem3.undoMove();
		
		Graphics boardg = bv.getGraphics();
		bv.paintComponent(boardg);
		String testboardstring =  board.toString();
		
		ExportLevelMove elm = new ExportLevelMove(bm, "testlevel");
		elm.doMove();
		elm.undoMove();
		
		ExportLevelMove elm2 = new ExportLevelMove(bm, "testlevel", true);
		elm2.doMove();
		
		
		
		
			
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
		
		AddLevelToGameMove altgm = new AddLevelToGameMove(builder.getBuilderModel(), 0);
		altgm.setLevelName("Release");
		altgm.doMove();
	
		
		ExportGameMove egm = new ExportGameMove(builder.getBuilderModel(), "testgame");
		egm.doMove();
		egm.undoMove();
		altgm.undoMove();
	}



}
