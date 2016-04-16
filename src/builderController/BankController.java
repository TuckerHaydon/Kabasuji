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
		this.bankView = bankView;
		this.bullpenView = bullpenView;
	}

	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
		
		System.out.println("Bank Clicked.");
		
		int cellNum = x / bankView.getCellWidth();
		
		System.out.println("Cell number: "+(cellNum + 1));
		
		Bank b = bankView.getBank();
		Tile t = null;
		
		try{
			t = b.getTiles().get(cellNum);
		}
		catch(ArrayIndexOutOfBoundsException e)
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
