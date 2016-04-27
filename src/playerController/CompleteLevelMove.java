package playerController;

import javax.swing.JOptionPane;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;

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
		System.out.println("CompleteLevelMove    lv.getIsComplete:  "+m.getCurrentLevel().getIsCompleted());
		
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
			
		}
		else{
			JOptionPane.showMessageDialog(null, "Level Failed!");
		}

		if(!app.getGameModel().IsTesting()){
			app.displayLevelSelectionMenu();
			app.getGameWindow().updateView();
		}
		return true;
	}

	@Override
	boolean isValid() {
		return m.getCurrentLevel().hasWon() || m.getCurrentLevel().cannotContinue();
	}
	
	@Override
	public boolean undo() {
		return false;
	}
}
