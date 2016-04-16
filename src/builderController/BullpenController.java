package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BankView;
import builderBoundary.BullpenView;
import builderEntity.Bank;

public class BullpenController extends MouseAdapter {
	
	BullpenView bullpenView;
	BankView bankView;
	
	public BullpenController(BullpenView bullpenView, BankView bankView) {
		this.bankView = bankView;
		this.bullpenView = bullpenView;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
		
		System.out.println("Bullpen Clicked.");
		
		int cellNum = x/bullpenView.getCellWidth();
		
		System.out.println("Clicked cell: "+(cellNum+1));
	}

}
