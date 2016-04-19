package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
import playerBoundary.LevelView;
import playerEntity.GameModel;

public class LevelController extends MouseAdapter {
	
	KabasujiPlayerApplication app;
	LevelView lv;
	
	public LevelController(KabasujiPlayerApplication app, LevelView lv){
		this.app = app;
		this.lv = lv;
	}
	
	//@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Level Pressed");
	}
}

