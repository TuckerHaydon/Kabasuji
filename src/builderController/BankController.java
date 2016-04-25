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
 * 
 * @author tuckerhaydon
 *
 */
public class BankController extends MouseAdapter {
	
	BullpenView bullpenView;
	BankView bankView;
	BuilderModel m;
	
	public BankController(BuilderModel m, BankView bankView, BullpenView bullpenView) {
		super();
		this.bankView = bankView;
		this.bullpenView = bullpenView;
		this.m = m;
	}

	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
		processMouseClicked(x,y);
		
	}
	
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
		
		AddTileToBullpenMove move = new AddTileToBullpenMove(m, t, bullpenView);
		move.execute();
	}
}
