package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BullpenController extends MouseAdapter {
	
	@Override
	public void mousePressed(MouseEvent me){
		System.out.println("Bullpen Pressed");
	}

}
