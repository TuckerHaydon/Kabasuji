package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelController extends MouseAdapter {
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Level Pressed");
	}

}
