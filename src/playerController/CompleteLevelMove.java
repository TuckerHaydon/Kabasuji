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
		
		if(m.getCurrentLevel().getStars() > 0){
			
			JOptionPane.showMessageDialog(null, "Level Won!");
			
			m.getCurrentLevel().setLevelComplete(true);
			
			if(m.getCurrentAM().updateAchievement_whengotonextlevel()){
				m.getCurrentAM().popUpScreen();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Level Failed!");
		}

		
		app.displayLevelSelectionMenu();
		app.getGameWindow().updateView();
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
