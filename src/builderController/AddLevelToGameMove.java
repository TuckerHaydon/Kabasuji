package builderController;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;
import builderEntity.Level;
import builderEntity.LevelParser;

/**
 * Adds a level to a game in the Game Editor. This class is used by
 * the corresponding handler to add made levels to a game being constructed.
 * @see AddLevelToGameHandler
 * @see GameEditor
 * @author tuckerhaydon
 * @author wilderj
 */
public class AddLevelToGameMove extends Move {
	
	int levelIndex;
	ArrayList<String> allnames;
	String levelname;
	
	public AddLevelToGameMove(BuilderModel m, int levelIndex) {
		super(m);
		
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
	public boolean execute(){
		
		if(!this.isValid()){
			return false;
		}
		
		this.requestName();
		return this.doMove();
	}

	@Override
	boolean doMove() {

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
