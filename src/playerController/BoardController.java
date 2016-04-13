package playerController;

import java.awt.event.MouseAdapter;
import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class BoardController extends MouseAdapter{
	GameModel m;
	KabasujiPlayerApplication app;
	
	public BoardController(GameModel m, KabasujiPlayerApplication app){
		this.app=app;
		this.m=m;
	}
	
	
	
	//achievement stuff will go there -Dorothy
	
}
