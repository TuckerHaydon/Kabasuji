package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class ResetLevelController implements ActionListener{
	KabasujiPlayerApplication app;
	GameModel m;

	public ResetLevelController(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		ResetLevelMove move = new ResetLevelMove(app,m);
		move.execute();
	}
	
}
