package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BankView;
import builderBoundary.BullpenView;
import builderBoundary.KabasujiBuilderApplication;
import builderEntity.Bank;
import builderEntity.BuilderModel;
import builderEntity.Tile;

/**
 * This class is responsible for controlling how the Tile Bank
 * responds to Builder's mouse events 
 * @see Bank 
 * 
 * @author tuckerhaydon
 *
 */
public class BankController extends MouseAdapter {
	
	BullpenView bullpenView;
	BankView bankView;
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	/**
	 * Bank Controller Constructor
	 * @param app
	 * @param m
	 * @param bankView
	 * @param bullpenView
	 */
	public BankController(KabasujiBuilderApplication app, BuilderModel m, BankView bankView, BullpenView bullpenView) {
		super();
		this.bankView = bankView;
		this.bullpenView = bullpenView;
		this.app = app;
		this.m = m;
	}

	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
		processMouseClicked(x,y);
		
	}
	
	/**
	 * determines what happens on a mouse click on the tile Bank
	 * @param x
	 * @param y
	 */
	void processMouseClicked(int x, int y){
		int cellNum = x / bankView.getCellWidth();
		
		Bank b = bankView.getBank();
		Tile t = null;
		
		try{
			t = b.getTiles().get(cellNum);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("No Tile there.");
			return;
		}
		
		AddTileToBullpenMove move = new AddTileToBullpenMove(app, m, t, bullpenView);
		move.execute();
	}
}
