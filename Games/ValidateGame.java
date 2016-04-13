import playerEntity.BoardElt;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.NumberBoardElt;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;

public class ValidateGame {
	Level[] levels;
	
	public ValidateGame(GameModel gm){
		this.levels = gm.getLevels();
	}
	
	public boolean isValid(){
		boolean flag;
		for (int i=0;i<15;i++)
		{
			if ((i%3 == 0) && (levels[i] instanceof PuzzleLevel)){
				flag = puzzleLevelValid((PuzzleLevel) levels[i]);
			}
			else if ((i%3 == 1) && (levels[i] instanceof LightningLevel)){
				flag = lightningLevelValid((LightningLevel) levels[i]);
			}
			else if ((i%3 == 2) && (levels[i] instanceof ReleaseLevel)){
				flag = releaseLevelValid((ReleaseLevel) levels[i]);
			}
			else{
				return false;
			}
			
			if (!flag){
				return false;
			}
		}
		return true;
	}
	
	public boolean lightningLevelValid(LightningLevel lLvl){
		if (!numBoardEltsValid(lLvl)){
			return false;
		}
		return true;
	}
	
	public boolean puzzleLevelValid (PuzzleLevel puzzleLvl){
		if (!numBoardEltsValid(puzzleLvl)){
			return false;
		}
		return true;
	}
	
	public boolean releaseLevelValid (ReleaseLevel relLvl){
		//TODO need to determine parameters when it is not valid
		return true;
	}
	
	public boolean numBoardEltsValid(Level l){
		BoardElt[][] b;
		b = l.getBoard().getBoardElts();
		
		for(int i=0;i<12;i++){
			for(int j=0;i<12;i++){
				if (b[i][j] instanceof NumberBoardElt){
					return false;
				}
			}
		}
		return true;
	}
}
