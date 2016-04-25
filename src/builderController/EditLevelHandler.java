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
 *
 */
public class EditLevelHandler implements ActionListener {
	
	KabasujiBuilderApplication app;
	BuilderModel m;
	
	public EditLevelHandler(KabasujiBuilderApplication app, BuilderModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File folder = new File("src/resources/levels/");
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> levelNames = new ArrayList<>();
		
		// Get all of the levels in the levels directory
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].getName().substring(0, 1).equals(".")) {
				levelNames.add(listOfFiles[i].getName());
		    }
		}
		
		String chosenLevelName = (String) JOptionPane.showInputDialog(null, "Choose a level to load", "Level Loader",
		        JOptionPane.QUESTION_MESSAGE, null, levelNames.toArray(), levelNames.get(0));

		String path = "src/resources/levels/"+chosenLevelName;
		
		Level editLevel = LevelParser.getLevel(path);
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

