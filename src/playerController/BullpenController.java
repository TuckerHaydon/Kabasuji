package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.Bullpen;

public class BullpenController extends MouseAdapter {
	
	KabasujiPlayerApplication app;
	Bullpen bp;
	
	public BullpenController(KabasujiPlayerApplication app, Bullpen bp){
		this.bp = bp;
		this.app = app;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		System.out.println("Bullpen Pressed");
		
		int x = me.getX();
		int y = me.getY();
		
		int cellNum;
		
		//determine if a tile is there
		//set that tile view to dragged
	}

}
