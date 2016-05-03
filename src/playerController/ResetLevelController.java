package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * Allows the player to reset the level (handles the button)
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
	
	/**
	 * Perform ResetLevelMove
	 */
	public void actionPerformed(ActionEvent e) {
		ResetLevelMove move = new ResetLevelMove(app,m);
		move.execute();
	}
	
}
