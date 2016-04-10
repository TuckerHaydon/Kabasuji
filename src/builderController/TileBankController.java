package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.TileBankView;

public class TileBankController extends MouseAdapter{
	
	TileBankView tbv;
	KabasujiBuilderApplication app;
	
	public TileBankController(TileBankView tbv, KabasujiBuilderApplication app){
		this.tbv = tbv;
		this.app = app;
	}
	
	public void mouseClicked(MouseEvent me){
		int x = me.getX();
		int y = me.getY();
		
		// TODO get the object at the location and create a handler for it
	}

}
