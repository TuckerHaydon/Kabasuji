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
 * 
 * @author jwilder
 * @author tuckerhaydon
 *
 */
public class EditLevelHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
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
	
	void processAction(){
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
		
		String chosenLevelName = (String) JOptionPane.showInputDialog(null, "Choose a level to load", "Level Loader",
		        JOptionPane.QUESTION_MESSAGE, null, levelNames.toArray(), levelNames.get(0));

		if(chosenLevelName == null){
			return;
		}
		
		// Determine which type of level it is.
		Level editLevel = null;
		
		try{
			String path = "src/resources/levels/puzzle/"+chosenLevelName;
			editLevel = LevelParser.getLevel(path);
			if(editLevel == null){
				throw new RuntimeException();
			}
		}
		catch(Exception e){};
		try{
			String path = "src/resources/levels/lightning/"+chosenLevelName;
			editLevel = LevelParser.getLevel(path);
			if(editLevel == null){
				throw new RuntimeException();
			}
		}
		catch(Exception e){};
		try{
			String path = "src/resources/levels/release/"+chosenLevelName;
			editLevel = LevelParser.getLevel(path);
			if(editLevel == null){
				throw new RuntimeException();
			}
		}
		catch(Exception e){};
		
		if(editLevel == null){
			System.err.println("Error in EditLevelHandler");
		}
		
		m.setLevel(editLevel);
		
		LevelEditor le = app.getLevelEditor();
		LevelBuilderView lbv = le.getLevelBuilderView();
		Level oldLevel = lbv.getLevel();
		oldLevel.setBoard(editLevel.getBoard());
		BoardView bv = new BoardView(editLevel.getBoard());
		BullpenView bpv = new BullpenView(editLevel.getBullpen());
		lbv.setBoardView(bv);
		lbv.setBullpenView(bpv);
		
		le.refresh();
		app.displayLevelEditor();
	}

}

