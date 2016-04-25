package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BankView;
import builderBoundary.BullpenView;
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
	BullpenView bullpenView;
	BankView bankView;
	
	public BullpenController(BuilderModel m, BullpenView bullpenView, BankView bankView) {
		super();

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
		
		RemoveTileFromBullpenMove move = new RemoveTileFromBullpenMove(m, t, bullpenView);
		move.execute();
	}

}
