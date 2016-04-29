package builderController;

import static org.junit.Assert.*;

import org.junit.Test;

import builderBoundary.BankView;
import builderBoundary.BoardView;
import builderBoundary.BullpenView;
import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.LevelBuilderView;
import builderBoundary.LevelEditor;
import builderEntity.Board;
import builderEntity.BuilderModel;
import builderEntity.Level;

public class testChangeBoardEltMove {

	@Test
	public void test() {
		BuilderModel m = BuilderModel.instance();
		KabasujiBuilderApplication builder = new KabasujiBuilderApplication(m);
		builder.init();
		Board board = m.getLevel().getBoard();
		LevelEditor le = builder.getLevelEditor();
		LevelBuilderView lbv = le.getLevelBuilderView();
		BullpenView bpv = lbv.getBullpenView();
		BoardView bv = lbv.getBoardView();
		BankView bankview = lbv.getBankView();
		Level lvl = lbv.getLevel();
		
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
	}

}
