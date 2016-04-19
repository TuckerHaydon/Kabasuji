package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BankView;
import builderBoundary.BullpenView;
import builderEntity.Bank;
import builderEntity.Tile;

public class BankController extends MouseAdapter {
	
	BullpenView bullpenView;
	BankView bankView;
	
	public BankController(BankView bankView, BullpenView bullpenView) {
		super();
		this.bankView = bankView;
		this.bullpenView = bullpenView;
	}

	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
				
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
		
		AddTileToBullpenMove move = new AddTileToBullpenMove(t, bullpenView);
		
		if(move.isValid()){
			move.doMove();
		}
	}
}
