package builderBoundary;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import builderEntity.Board;
import builderEntity.BoardElt;
import builderEntity.NumberedBoardElt;
import builderEntity.PlayableBoardElt;
import builderEntity.UnplayableBoardElt;

public class BoardView extends View {

	Board b;
	
	public BoardView(Board b){
		this.b = b;
	}
	
	void initView(){
		this.setBackground(new Color(255, 50, 50));
		this.setBounds(0, 0, 4000, 4000);
	}
	
}
