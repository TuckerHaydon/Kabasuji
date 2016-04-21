package playerController;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;

/**
 * 
 * @author 
 *
 */
public class ResetLevelMove implements IMove{
	KabasujiPlayerApplication app;
	GameModel m;
	int[] data;
	
	public ResetLevelMove(KabasujiPlayerApplication app, GameModel m){
		this.app=app;
		this.m=m;
	}

	public boolean doMove(KabasujiPlayerApplication app) {
		Level l = m.getCurrentLevel();
		data[0] = l.getScore();
		if(l instanceof LightningLevel) {
			data[1] = ((LightningLevel) l).getUsedTime();
		} else if(l instanceof ReleaseLevel) {
			data[1] = ((ReleaseLevel) l).getNumLeft();
		} else {
			data[1] = ((PuzzleLevel) l).getUsedMoves();
		}
		System.out.println("Reset!");
		m.getCurrentLevel().reset();
		return true;
	}
	
	public boolean isValid(KabasujiPlayerApplication app) {
		return true;
	}
	
	public boolean undo(KabasujiPlayerApplication app) {
		Level l = m.getCurrentLevel();
		l.setScore(data[0]);
		if(l instanceof LightningLevel) {
			((LightningLevel) l).setUsedTime(data[1]);
			return true;
		} else if(l instanceof ReleaseLevel) {
			((ReleaseLevel) l).setNumLeft(data[1]);
			return true;
		} else {
			((PuzzleLevel) l).setUsedMoves(data[1]);
			return true;
		} 
	}

}
