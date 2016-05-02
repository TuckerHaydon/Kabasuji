package playerController;

import javax.swing.JOptionPane;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameAchievementMonitor;
import playerEntity.GameModel;
import playerEntity.LightningLevel;

/**
 * Move to finish a level
 * @author dorothy, tuckerhaydon
 *
 */
public class CompleteLevelMove extends Move{
	
	/**
	 * Constructor for CompleteLevelMove
	 * @param app - top-level kabasuji player application
	 * @param m - top-level game model
	 */
	public CompleteLevelMove(KabasujiPlayerApplication app, GameModel m){
		super(app, m);
	}
	
	/**
	 * Checks to see if the player has gotten at least one star in the level,
	 * which means they have met the minimum requirements for winning that level
	 */
	@Override
	public boolean doMove() {
		
		if(m.getCurrentLevel().getStars() > 0){
			
			JOptionPane.showMessageDialog(null, "Level Won!");
			
			int thisLevelIndex = m.getCurrentLevel().getLevelNum() - 1;
			
			// Ensure that by winning the last level it does not try and unlock an imaginary level
			try{
				m.getLevels()[thisLevelIndex+3].setIsUnlocked(true);
			}
			catch(Exception e){} 
			
			m.getCurrentLevel().setLevelComplete(true);
			
			if(m.getCurrentAM().updateAchievement_whencompletelevel()){
				m.getCurrentAM().popUpScreen();
			}
			
			m.getGAM().updateAchievement(m.getCurrentLevel().getLevelNum());
			
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
			m.getGAM().pop();
			
		}
		
		if(m.getCurrentLevel() instanceof LightningLevel){
			if(app.getGameWindow().getDraggedTile()!=null){
				app.getGameWindow().releaseDraggedTile();
			}
		}
		
		return true;
	}

	/**
	 * Checks for validity of move
	 */
	@Override
	boolean isValid() {
		return m.getCurrentLevel().getStars() == 3 || m.getCurrentLevel().cannotContinue();
	}
	
	@Override
	public boolean undo() {
		return false;
	}
}
