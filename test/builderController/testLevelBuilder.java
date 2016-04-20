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
		
		//initialize the builder
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication();
		builder.init();
		builder.displaySplashScreen();
		builder.displayLevelEditor();

		//instantiate entities/views for testing
		BuilderModel bm = builder.getBuilderModel();
		LevelEditor le = builder.getLevelEditor();
		LevelBuilderView lbv = le.getLevelBuilderView();
		BullpenView bpv = lbv.getBullpenView();
		BoardView bv = lbv.getBoardView();
		BankView bankview = lbv.getBankView();
		Level lvl = lbv.getLevel();
		Board board = lvl.getBoard();

		//test changing view based off level type
		lbv.updateView("puzzle");
		lbv.updateView("lightning");
		lbv.updateView("release");

		//navigate to level editor menu screen
		builder.displayLevelEditorMenu();
		
		//create controllers for views on levelBuilderView
		BullpenController bpc = new BullpenController(bpv, bankview);
		BoardController boardc = new BoardController(bv, bm);
		BankController bkc = new BankController(bankview, bpv);

		//dummy test for mouse clicked on bankController
		MouseEvent meBank = new MouseEvent(bankview, 0, 0, 0, 0, 20, 20, false);
		bkc.mouseClicked(meBank);
		
		//dummy test for mouse pressed on boardController
		MouseEvent meBoard = new MouseEvent(bankview, 0, 0, 0, 0, 20, 20, false);
		boardc.mousePressed(meBoard);

		//dummy test for mouse clicked on bullpenController
		MouseEvent meBullpen = new MouseEvent(bankview, 0, 0, 0, 0, 20, 20, false);
		bpc.mouseClicked(meBullpen);
		
		
		//create some tiles for adding to the bullpen
		Tile tile1 = new Tile(1, "bullpen");
		Tile tile2 = new Tile(2, "bullpen");

		//now add those tiles to the bullpen, then undo the second addition
		AddTileToBullpenMove attbpm = new AddTileToBullpenMove(tile1, bpv);
		attbpm.doMove();
		AddTileToBullpenMove attbpm2 = new AddTileToBullpenMove(tile2, bpv);
		attbpm2.doMove();
		attbpm2.undoMove();

		//change the type of the level to be release
		SetLevelTypeMove sltm = new SetLevelTypeMove(lvl, "release", lbv);
		sltm.doMove();

		//make a new board elt with a green 2, then undo it
		bm.setSelectedBoardEltType("numbered");
		bm.setSelectedColor("green");
		bm.setSelectedNumber(2);
		ChangeBoardEltMove cbem = new ChangeBoardEltMove(bm, board, 1, 1);
		cbem.doMove();
		cbem.undoMove();
		
		//change the color to red and repeat
		bm.setSelectedColor("red");
		cbem.doMove();
		cbem.undoMove();
		
		//finally try blue
		bm.setSelectedColor("blue");
		cbem.doMove();
		
		//get/set attributes of builderModel
		bm.setLevel(lvl);
		bm.getTileBank();
		bm.setHintSelected(true);
		bm.isHintSelected();
		bm.setSelectedBoardEltType("playable");
		
		//change a new playable board elt as a hint
		ChangeBoardEltMove cbem2 = new ChangeBoardEltMove(bm, board, 1, 2);
		cbem2.doMove();

		//change a board elt to be unplayable, then undo
		bm.setSelectedBoardEltType("unplayable");
		ChangeBoardEltMove cbem3 = new ChangeBoardEltMove(bm, board, 1, 3);
		cbem3.doMove();
		cbem3.undoMove();
		
		//make sure that drawTileBank, drawTile, drawBoard works
		Graphics bankg = bankview.getGraphics();
		bankview.paintComponent(bankg);
		Graphics g = bpv.getGraphics();
		bpv.paintComponent(g);
		Graphics boardg = bv.getGraphics();
		bv.paintComponent(boardg);
		
		//test toString method on builderModel and board
		String bmstring = bm.toString();
		String testboardstring =  board.toString();
		
		//export the level, then undo it (shouldn't this be impossible?)
		ExportLevelMove elm = new ExportLevelMove(bm, "testlevel");
		elm.doMove();
		elm.undoMove();

		//now export the level with overwrite = true
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
