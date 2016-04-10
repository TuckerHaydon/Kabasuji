package builderBoundary;

import javax.swing.JPanel;

import builderEntity.Level;

public class LevelBuilderView extends JPanel{
	
	BullpenView bullpenView;
	TileBankView bankView;
	BoardView boardView;
	Level lvl;
	
	public LevelBuilderView(BullpenView bpv, TileBankView tbv, BoardView bv, Level lvl){
		this.bullpenView = bpv;
		this.bankView = tbv;
		this.boardView = bv;
		this.lvl = lvl;
	}

}
