package playerController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

/**
 * 
 * @author dorothy
 *
 */
public class ResetAchievementController implements ActionListener{
	KabasujiPlayerApplication app;
	GameModel m;
	
	
	public ResetAchievementController(KabasujiPlayerApplication app, GameModel m){
		this.m=m;
		this.app=app;
	}
	
	/*Finished*/	
	public void actionPerformed(ActionEvent e) {
		
		ResetAchievementMove move = new ResetAchievementMove(app, m, m.getAchievements());
		if(move.execute()){
			app.getGameWindow().updateView();
			app.getAchievementsMenu().updateView();
			System.out.println("ResetAchievementController::actionPerformed");
		}
		
		
	}

}
