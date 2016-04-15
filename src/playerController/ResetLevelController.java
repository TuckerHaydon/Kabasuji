package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

public class ResetLevelController implements ActionListener{
	KabasujiPlayerApplication app;
	GameModel m;

	public ResetLevelController(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
	}
	
	/*Finished*/
	public void actionPerformed(ActionEvent e) {
		IMove move = new ResetLevelMove(app,m);
		if(move.doMove(app)){
			app.getGameWindow().updateView();
		}
	}
	
}
