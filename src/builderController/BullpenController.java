package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BankView;
import builderBoundary.BullpenView;
import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import builderEntity.Bullpen;
import builderEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class BullpenController extends MouseAdapter {
	
	BuilderModel m;
	KabasujiBuilderApplication app;
	BullpenView bullpenView;
	BankView bankView;
	
	/**
	 * Bullpen Controller Constructor
	 * @param app
	 * @param m
	 * @param bullpenView
	 * @param bankView
	 */
	public BullpenController(KabasujiBuilderApplication app, BuilderModel m, BullpenView bullpenView, BankView bankView) {
		super();

		this.app = app;
		this.m = m;
		this.bankView = bankView;
		this.bullpenView = bullpenView;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
		
		processMouseClicked(x, y);
	}
	
	/**
	 * processes what happens on a mouse clicked event on the bullpen
	 * @param x
	 * @param y
	 */
	void processMouseClicked(int x, int y){
		int cellNum = x/bullpenView.getCellWidth();
		
		Bullpen bullpen = bullpenView.getBullpen();
		Tile t = null;
		
		try{
			t = bullpen.getTiles().get(cellNum);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("No tile there.");
			return;
		}
		
		RemoveTileFromBullpenMove move = new RemoveTileFromBullpenMove(app, m, t, bullpenView);
		move.execute();
	}

}
