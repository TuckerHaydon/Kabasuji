package builderController;

import java.awt.Color;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.Board;
import builderEntity.BoardElt;
import builderEntity.BuilderModel;
import builderEntity.NumberedBoardElt;
import builderEntity.PlayableBoardElt;
import builderEntity.UnplayableBoardElt;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class ChangeBoardEltMove extends Move {
	
	String selectedBoardEltType, selectedColor, prevType;
	Color prevColor;
	int selectedNumber, prevNumber;
	int row, col;
	Board board;
	boolean isHint, prevHint;
	
	public ChangeBoardEltMove(KabasujiBuilderApplication app, BuilderModel model, Board board, int row, int col) {
		super(app, model);
		
		this.board = board;
		this.row = row;
		this.col = col;
		this.selectedBoardEltType = model.getSelectedBoardEltType();
		this.selectedColor = model.getSelectedColor();
		this.selectedNumber = model.getSelectedNumber();
		isHint = model.isHintSelected();
	}

	@Override
	boolean doMove() {
		
		BoardElt b = board.getBoardElts()[row][col];
		if (b instanceof PlayableBoardElt) {
			prevHint = ((PlayableBoardElt)board.getBoardElts()[row][col]).isHint();
			if(b instanceof NumberedBoardElt) {
				prevColor = ( (NumberedBoardElt) board.getBoardElts()[row][col]).getColor();
				prevType = "numbered"; 
			} else {
				prevType = "playable";
			}
		} else {
			prevType = "unplayable";
		}
		
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
	boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean undoMove() {
		switch(prevType){
		case "playable":
			board.getBoardElts()[row][col] = new PlayableBoardElt(row, col, prevHint);
			break;
		case "unplayable": 
			board.getBoardElts()[row][col] = new UnplayableBoardElt(row, col);
			break;
		case "numbered":
			board.getBoardElts()[row][col] = new NumberedBoardElt(row, col, isHint, prevColor, selectedNumber); 
			break;
		default:
			System.err.println("Something wrong with the board elt type selection in ChangeBoardEltMove");
			return false;
		}
		
		return true;
	}

}
