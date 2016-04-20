package builderController;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import builderEntity.BuilderModel;
import builderEntity.Level;
import builderEntity.LevelParser;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class AddLevelToGameMove implements IMove {
	
	BuilderModel m;
	int levelIndex;
	
	public AddLevelToGameMove(BuilderModel m, int levelIndex) {
		this.m = m;
		this.levelIndex = levelIndex;
	}

	@Override
	public boolean doMove() {
		
		File folder = new File("src/resources/levels/");
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> levelNames = new ArrayList<>();
		
		// Get all of the levels in the levels directory
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].getName().substring(0, 1).equals(".")) {
				levelNames.add(listOfFiles[i].getName());
		    }
		}
		
		String chosenLevelName = (String) JOptionPane.showInputDialog(null, "Choose a level to add", "Level "+levelIndex,
		        JOptionPane.QUESTION_MESSAGE, null, levelNames.toArray(), levelNames.get(0));

		return processName(chosenLevelName);
	}
	
	boolean processName (String chosenLevelName) {

		String path = "src/resources/levels/"+chosenLevelName;
		Level lvl = LevelParser.getLevel(path);
		lvl.setLevelNum(levelIndex);
		
		m.getGame().setLevel(lvl, levelIndex);
		return true;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public boolean undoMove() {
		
		m.getGame().setLevel(null, levelIndex);
		
		return true;
	}

}
