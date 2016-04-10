package builderBoundary;

import javax.swing.JPanel;

import builderEntity.Board;

public class BoardView extends JPanel {

	Board b;
	
	public BoardView(Board b){
		this.b = b;
	}
}
