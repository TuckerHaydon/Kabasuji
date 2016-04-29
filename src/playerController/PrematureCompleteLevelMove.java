package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.LightningLevel;
/***
 * Handles the logic of the complete level button
 * 
 * @author Damani
 *
 */
public class PrematureCompleteLevelMove implements ActionListener {
	KabasujiPlayerApplication app;
	GameModel m;
	
	public PrematureCompleteLevelMove(KabasujiPlayerApplication app,GameModel m) {
		this.app = app;
		this.m=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {

		Move move = new CompleteLevelMove(app,m);
		move.doMove();
	}

}
