package builderController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BullpenController extends MouseAdapter {
	
	
	@Override
	public void mouseClicked(MouseEvent me){
		
		int x = me.getX();
		int y = me.getY();
		
		System.out.println("Bullpen Clicked.");
	}

}
