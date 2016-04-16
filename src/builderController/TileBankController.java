package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.BankView;

public class TileBankController extends MouseAdapter{
	
	BankView tbv;
	KabasujiBuilderApplication app;
	
	public TileBankController(BankView tbv, KabasujiBuilderApplication app){
		this.tbv = tbv;
		this.app = app;
	}
	
	public void mouseClicked(MouseEvent me){
		int x = me.getX();
		int y = me.getY();
		
		// TODO get the object at the location and create a handler for it
	}

}
