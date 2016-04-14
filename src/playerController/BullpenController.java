package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerEntity.Bullpen;

public class BullpenController extends MouseAdapter {
	
	Bullpen bp;
	
	public BullpenController(Bullpen bp){
		this.bp = bp;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		System.out.println("Bullpen Pressed");
	}

}
