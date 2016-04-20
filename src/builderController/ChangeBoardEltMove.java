package builderController;

import java.awt.Color;

import builderEntity.Board;
import builderEntity.BuilderModel;
import builderEntity.NumberedBoardElt;
import builderEntity.PlayableBoardElt;
import builderEntity.UnplayableBoardElt;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class ChangeBoardEltMove implements IMove {
	
	String selectedBoardEltType, selectedColor, prevBoardEltType, prevColor; 
	int selectedNumber, prevNumber;
	int row, col;
	Board board;
	boolean isHint, prevHint;
	
	public ChangeBoardEltMove(BuilderModel model, Board board, int row, int col) {
		this.board = board;
		this.row = row;
		this.col = col;
		this.selectedBoardEltType = model.getSelectedBoardEltType();
		this.selectedColor = model.getSelectedColor();
		this.selectedNumber = model.getSelectedNumber();
		isHint = model.isHintSelected();
		
		//need previous state for undo
//		this.prevBoardEltType = board.getBoardElts()[row][col].getType();
//		this.prevColor = ( (NumberedBoardElt)board.getBoardElts()[row][col]).getColorString();
//		this.prevHint = ((PlayableBoardElt)board.getBoardElts()[row][col]).isHint();
	}

	@Override
	public boolean doMove() {
		
		switch(selectedBoardEltType){
		case "playable":
			board.getBoardElts()[row][col] = new PlayableBoardElt(row, col, isHint);
			break;
		case "unplayable": 
			board.getBoardElts()[row][col] = new UnplayableBoardElt(row, col);
			break;
		case "numbered":
			
			Color c = Color.BLACK;
			if(selectedColor.equals("red")){c = Color.RED;}
			else if(selectedColor.equals("blue")){c = Color.BLUE;}
			else if(selectedColor.equals("green")){c = Color.GREEN;}
			
			board.getBoardElts()[row][col] = new NumberedBoardElt(row, col, isHint, c, selectedNumber); 
			break;
		default:
			System.err.println("Something wrong with the board elt type selection in ChangeBoardEltMove");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}

}
