package builderController;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import builderBoundary.BoardView;
import builderBoundary.BullpenView;
import builderBoundary.KabasujiBuilderApplication;
import builderBoundary.LevelBuilderView;
import builderBoundary.LevelEditor;
import builderEntity.BuilderModel;
import builderEntity.Level;
import builderEntity.LevelParser;

/**
 * EditLevelHandler class
 * This class is responsible for handling the editLevel action.
 * 
 * @author jwilder
 * @author tuckerhaydon
 *
 */
public class EditLevelHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	/**
	 * EditLevelHandler constructor
	 * @param app
	 * @param m
	 */
	public EditLevelHandler(KabasujiBuilderApplication app, BuilderModel m) {
		
		if(app == null || m == null){
			throw new RuntimeException();
		}
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		processAction();
	}
	
	/**
	 * processes the editLevel action
	 */
	void processAction(){
		ArrayList<String> levelNames = addLevels();
		String chosenLevelName = (String) JOptionPane.showInputDialog(null, "Choose a level to load", "Level Loader",
		        JOptionPane.QUESTION_MESSAGE, null, levelNames.toArray(), levelNames.get(0));
		parseLevel(chosenLevelName);

	}
	
	/**
	 * returns an array of all the levels currently in the resource
	 * folder  
	 * @return arrayList of levels
	 */
	public ArrayList<String> addLevels(){
		ArrayList<String> levelNames = new ArrayList<>();
		
		File folder = new File("src/resources/levels/lightning/");
		File[] listOfFiles = folder.listFiles();

		
		// Get all of the levels in the levels directory
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].getName().substring(0, 1).equals(".")) {
				levelNames.add(listOfFiles[i].getName());
		    }
		}
		
		folder = new File("src/resources/levels/release/");
		listOfFiles = folder.listFiles();
		
		// Get all of the levels in the levels directory
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].getName().substring(0, 1).equals(".")) {
				levelNames.add(listOfFiles[i].getName());
		    }
		}
		
		folder = new File("src/resources/levels/puzzle/");
		listOfFiles = folder.listFiles();
		
		// Get all of the levels in the levels directory
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].getName().substring(0, 1).equals(".")) {
				levelNames.add(listOfFiles[i].getName());
		    }
		}
		
		return levelNames;
	}
	
	/**
	 * parses an individual level to determine what needs to be displayed
	 * @param chosenLevelName
	 */
	void parseLevel(String chosenLevelName){

		if(chosenLevelName == null){
			return;
		}
		
		// Determine which type of level it is.
		Level editLevel = null;
		
		if(editLevel == null){
			String path = "src/resources/levels/puzzle/"+chosenLevelName;
			editLevel = LevelParser.getLevel(path);
		}
		if(editLevel == null){
			String path = "src/resources/levels/lightning/"+chosenLevelName;
			editLevel = LevelParser.getLevel(path);
		}
		if(editLevel == null){
			String path = "src/resources/levels/release/"+chosenLevelName;
			editLevel = LevelParser.getLevel(path);
		}
		if(editLevel == null){
			System.err.println("Error in EditLevelHandler");
		}
		
		m.setLevel(editLevel);
		
		
		LevelEditor le = app.getLevelEditor();
		LevelBuilderView lbv = le.getLevelBuilderView();
		BoardView bv = new BoardView(editLevel.getBoard());
		BullpenView bpv = new BullpenView(editLevel.getBullpen());
		lbv.setBoardView(bv);
		lbv.setBullpenView(bpv);
		
		le.refresh();
		app.displayLevelEditor();
	}

}

