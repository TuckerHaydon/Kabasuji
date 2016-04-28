package playerController;

import javax.swing.JOptionPane;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameAchievementMonitor;
import playerEntity.GameModel;
import playerEntity.LightningLevel;

/**
 * 
 * @author dorothy, tuckerhaydon
 *
 */
public class CompleteLevelMove extends Move{
	
	public CompleteLevelMove(KabasujiPlayerApplication app, GameModel m){
		super(app, m);
	}
	
	@Override
	public boolean doMove() {
		
		if(m.getCurrentLevel().getStars() > 0){
			
			JOptionPane.showMessageDialog(null, "Level Won!");
			
			int thisLevelIndex = m.getCurrentLevel().getLevelNum() - 1;
			
			// Ensure that by winning the last level it does not try and unlock an imaginary level
			try{
				m.getLevels()[thisLevelIndex+1].setIsUnlocked(true);
			}
			catch(Exception e){} 
			
			
			if(m.getCurrentAM().updateAchievement_whencompletelevel()){
				m.getCurrentAM().popUpScreen();
			}
			
			
			if(m.getCurrentLevel().getStars() == 3){
				m.getCurrentLevel().setLevelComplete(true);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Level Failed!");
			if(m.getCurrentAM().updateAchievement_whencompletelevel()){
				m.getCurrentAM().popUpScreen();
			}
		}

		if(!app.getGameModel().IsTesting()){
			app.displayLevelSelectionMenu();
			app.getGameWindow().updateView();
			
			GameAchievementMonitor GAM = m.getGAM();
			if(GAM.updateAchievement(m.getCurrentLevel().getLevelNum())){
				GAM.pop();
			}
		}
		
		if(m.getCurrentLevel() instanceof LightningLevel){
			if(app.getGameWindow().getDraggedTile()!=null){
				app.getGameWindow().releaseDraggedTile();
			}
		}
		
		return true;
	}

	@Override
	boolean isValid() {
		return m.getCurrentLevel().getStars() == 3 || m.getCurrentLevel().cannotContinue();
	}
	
	@Override
	public boolean undo() {
		return false;
	}
}
