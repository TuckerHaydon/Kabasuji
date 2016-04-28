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
		System.out.println("PrematureCompleteLevelMove    lv.getIsComplete:  "+m.getCurrentLevel().getIsCompleted());
		
		if(m.getCurrentLevel().getStars() > 0){
			
			JOptionPane.showMessageDialog(null, "Level Won!");
			
			int thisLevelIndex = m.getCurrentLevel().getLevelNum() - 1;
			
			// Ensure that by winning the last level it does not try and unlock an imaginary level
			try{
				m.getLevels()[thisLevelIndex+1].setIsUnlocked(true);
			}
			catch(Exception e){} 
			
			
			if(m.getCurrentAM().updateAchievement_whengotonextlevel()){
				m.getCurrentAM().popUpScreen();
			}
			
			if(m.getCurrentLevel().hasWon()){
				m.getCurrentLevel().setLevelComplete(true);
			}
		}
		
		if(!app.getGameModel().IsTesting()){
			app.displayLevelSelectionMenu();
			app.getGameWindow().updateView();
		}
		
		if(m.getCurrentLevel() instanceof LightningLevel){
			app.getGameWindow().releaseDraggedTile();
		}
		
	}

}
