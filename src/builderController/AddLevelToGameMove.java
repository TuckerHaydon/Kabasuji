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
 * @author wilderj
 */
public class AddLevelToGameMove implements IMove {
	
	BuilderModel m;
	int levelIndex;
	ArrayList<String> allnames;
	String levelname;
	
	public AddLevelToGameMove(BuilderModel m, int levelIndex) {
		this.m = m;
		this.levelIndex = levelIndex;
		
		File folder = new File("src/resources/levels/");
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> levelNames = new ArrayList<>();
		
		// Get all of the levels in the levels directory
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].getName().substring(0, 1).equals(".")) {
				levelNames.add(listOfFiles[i].getName());
		    }
		}
		
		allnames = levelNames;
		
	}

	@Override
	public boolean doMove() {

		String path = "src/resources/levels/"+levelname;
		Level lvl = LevelParser.getLevel(path);
		lvl.setLevelNum(levelIndex);
		
		m.getGame().setLevel(lvl, levelIndex);
		return true;
	}
	
	public boolean requestName(){
		levelname = (String) JOptionPane.showInputDialog(null, "Choose a level to add", "Level "+levelIndex,
		        JOptionPane.QUESTION_MESSAGE, null, allnames.toArray(), allnames.get(0));

		return true;
	}
	
//	public boolean processName (String chosenLevelName) {
//
//		String path = "src/resources/levels/"+chosenLevelName;
//		Level lvl = LevelParser.getLevel(path);
//		lvl.setLevelNum(levelIndex);
//		
//		m.getGame().setLevel(lvl, levelIndex);
//		return true;
//	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public boolean undoMove() {
		
		m.getGame().setLevel(null, levelIndex);
		
		return true;
	}
	
	public void setLevelName(String name){
		this.levelname = name;
	}

}
