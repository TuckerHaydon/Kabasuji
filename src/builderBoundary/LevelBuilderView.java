package builderBoundary;

import javax.swing.JPanel;

import builderEntity.Level;

public class LevelBuilderView extends JPanel{
	
	BullpenView bullpenView;
	TileBankView bankView;
	BoardView boardView;
	Level lvl;
	
	public LevelBuilderView(Level lvl){
		this.lvl = lvl;
	}
	
	public void initView(){
		// bullpenView = new BullpenView();
		// TODO
	}
	
	public void initControllers(){
		// TODO
	}

}
