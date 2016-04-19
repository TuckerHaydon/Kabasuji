package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BankView;
import builderBoundary.BullpenView;
import builderEntity.Bank;
import builderEntity.Bullpen;
import builderEntity.Tile;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class BullpenController extends MouseAdapter {
	
	BullpenView bullpenView;
	BankView bankView;
	
	public BullpenController(BullpenView bullpenView, BankView bankView) {
		super();
		this.bankView = bankView;
		this.bullpenView = bullpenView;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
				
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
		
		RemoveTileFromBullpenMove move = new RemoveTileFromBullpenMove(t, bullpenView);
		
		if(move.isValid()){
			move.doMove();
		}
		
		
		
	}

}
