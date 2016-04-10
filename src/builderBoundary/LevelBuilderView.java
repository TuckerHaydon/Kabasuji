package builderBoundary;

import javax.swing.JPanel;

import builderController.BoardController;
import builderEntity.Level;

public class LevelBuilderView extends JPanel{
	
	BullpenView bullpenView;
	TileBankView bankView;
	BoardView boardView;
	Level lvl;
	KabasujiBuilderApplication app;
	
	public LevelBuilderView(Level lvl, KabasujiBuilderApplication app){
		this.lvl = lvl;
		this.app = app;
	}
	
	public void initView(){
		bullpenView = new BullpenView(lvl.getBullpen());
		boardView = new BoardView(lvl.getBoard());
		// bankView = new BankView();
		
		this.add(bullpenView);
		this.add(boardView);
	}
	
	public void initControllers(){
		boardView.addMouseListener(new BoardController(boardView, app));
		// TODO add handlers for the bullpen and bank
	}

}
