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
		System.out.println("Doing a completeLevelMove");
		
		if(m.getCurrentLevel().getStars() > 0){
			
			JOptionPane.showMessageDialog(null, "Level Won!");
			
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
