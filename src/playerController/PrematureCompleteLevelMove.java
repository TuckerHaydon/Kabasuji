package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
/***
 * Handles the logic of the complete level button
 * 
 * @author dgwalder
 *
 */
public class PrematureCompleteLevelMove implements ActionListener {
	KabasujiPlayerApplication app;
	GameModel m;
	
	public PrematureCompleteLevelMove(KabasujiPlayerApplication app,GameModel m) {
		this.app = app;
		this.m=m;
	}
	
	/**
	 * Perform the CompleteLevelMove
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {

		Move move = new CompleteLevelMove(app,m);
		move.doMove();
	}

}
