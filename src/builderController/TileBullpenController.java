package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import builderBoundary.BullpenView;
import builderBoundary.KabasujiBuilderApplication;

public class TileBullpenController extends MouseAdapter {
	
	BullpenView bpv;
	KabasujiBuilderApplication app;
	
	public TileBullpenController(BullpenView bpv, KabasujiBuilderApplication app){
		this.bpv = bpv;
		this.app = app;
	}
	
	@Override
	public void mouseClicked(MouseEvent me){
		int x = me.getX();
		int y = me.getY();
		
		// TODO find the object at the location and create a handler for it
	}

}
