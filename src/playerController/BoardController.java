package playerController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class BoardController extends MouseAdapter{
	GameModel m;
	KabasujiPlayerApplication app;
	
	public BoardController(GameModel m, KabasujiPlayerApplication app){
		this.app=app;
		this.m=m;
	}
	
	public void mousePressed(MouseEvent me){
	
		System.out.println("Board Pressed");
	}
	
	
	public void mouseRelease(MouseEvent me){
		
		
		
		
		
		//achievement stuff goes here!
		
		
	}
	
}
