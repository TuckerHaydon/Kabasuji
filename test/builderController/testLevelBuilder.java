package builderController;


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
import builderEntity.Board;
import builderEntity.BuilderModel;
import builderEntity.Bullpen;
import builderEntity.Level;
import builderEntity.Tile;



public class testLevelBuilder {


	protected void setUp(){

	}

	@Test
	public void testCreateLevel() {
		
		//initialize the builder
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication(m);
		builder.init();
		builder.displaySplashScreen();
		builder.displayLevelEditor();

		//instantiate entities/views for testing
		LevelEditor le = builder.getLevelEditor();
		
		LevelBuilderView lbv = le.getLevelBuilderView();
		BullpenView bpv = lbv.getBullpenView();
		BoardView bv = lbv.getBoardView();
		BankView bankview = lbv.getBankView();
		Level lvl = lbv.getLevel();
		Board board = lvl.getBoard();

		//test changing view based off level type
		lbv.changeViewLevelType("puzzle");
		lbv.changeViewLevelType("lightning");
		lbv.changeViewLevelType("release");

		//navigate to level editor menu screen
		builder.displayLevelEditorMenu();
		
		//create controllers for views on levelBuilderView
		BullpenController bpc = new BullpenController(builder, m, bpv, bankview);
		BoardController boardc = new BoardController(builder, m, bv);
		BankController bkc = new BankController(builder, m, bankview, bpv);

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
		AddTileToBullpenMove attbpm = new AddTileToBullpenMove(builder, m, tile1, bpv);
		attbpm.execute();
		AddTileToBullpenMove attbpm2 = new AddTileToBullpenMove(builder, m, tile2, bpv);
		attbpm2.execute();
		attbpm2.executeUndo();

		//change the type of the level to be release
		SetLevelTypeMove sltm = new SetLevelTypeMove(builder, m, "release");
		sltm.execute();

		//make a new board elt with a green 2, then undo it
		m.setSelectedBoardEltType("numbered");
		m.setSelectedColor("green");
		m.setSelectedNumber(2);
		ChangeBoardEltMove cbem = new ChangeBoardEltMove(builder, m, board, 1, 1);
		cbem.execute();
		cbem.executeUndo();
		
		//change the color to red and repeat
		m.setSelectedColor("red");
		cbem.execute();
		cbem.executeUndo();
		
		//finally try blue
		m.setSelectedColor("blue");
		cbem.execute();
		
		//get/set attributes of builderModel
		m.setLevel(lvl);
		m.getTileBank();
		m.setHintSelected(true);
		m.isHintSelected();
		m.setSelectedBoardEltType("playable");
		
		//change a new playable board elt as a hint
		ChangeBoardEltMove cbem2 = new ChangeBoardEltMove(builder, m, board, 1, 2);
		cbem2.execute();

		//change a board elt to be unplayable, then undo
		m.setSelectedBoardEltType("unplayable");
		ChangeBoardEltMove cbem3 = new ChangeBoardEltMove(builder, m, board, 1, 3);
		cbem3.execute();
		cbem3.executeUndo();
		
		//test toString method on builderModel and board
		String bmstring = m.toString();
		String testboardstring =  board.toString();
		
		//export the level, then undo it (shouldn't this be impossible?)
		ExportLevelMove elm = new ExportLevelMove(builder, m, "testlevel");
		elm.execute();
		elm.executeUndo();

		//now export the level with overwrite = true
		ExportLevelMove elm2 = new ExportLevelMove(builder, m, "testlevel", true);
		elm2.execute();
	}

	@Test
	public void testCreateGame(){
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication(m);
		builder.init();
		builder.displayLevelEditor();

		LevelEditor le = builder.getLevelEditor();
		LevelBuilderView lbv = le.getLevelBuilderView();
		LevelEditorMenu lem = builder.getLevelEditorMenu();
		GameEditor ge = builder.getGameEditor();
		GameEditorMenu gem = builder.getGameEditorMenu();
		MainMenu mm = builder.getMainMenu();
		BullpenView bpv = lbv.getBullpenView();


		lbv.changeViewLevelType("puzzle");
		lbv.changeViewLevelType("lightning");
		lbv.changeViewLevelType("release");

		Level lvl = lbv.getLevel();
		Bullpen bp = lvl.getBullpen();
		Board board = lvl.getBoard();

		ActionEvent me3 = new ActionEvent(mm, 0, null);
		NavigateGameEditorMenu ngem = new NavigateGameEditorMenu(builder);
		ngem.actionPerformed(me3);

		ActionEvent me4 = new ActionEvent(gem, 0, null);
		CreateGameHandler cgh = new CreateGameHandler(builder, m);
		cgh.actionPerformed(me4);

		AddLevelToGameMove altgm = new AddLevelToGameMove(builder, m, 0);
		altgm.setLevelName("Release");
		altgm.execute();


		ExportGameMove egm = new ExportGameMove(builder, m, "testgame");
		egm.execute();
		egm.executeUndo();
		altgm.executeUndo();
	}



}
