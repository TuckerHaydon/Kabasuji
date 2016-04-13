package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardController extends MouseAdapter {
	
	@Override
	public void mousePressed(MouseEvent me){
		System.out.println("Board Pressed");
	}

}
