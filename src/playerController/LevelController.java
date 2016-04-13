package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class LevelController extends MouseAdapter {

	
	public LevelController(){
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse Pressed");
	}

}
