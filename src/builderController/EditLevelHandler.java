package builderController;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import builderBoundary.KabasujiBuilderApplication;
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
		
		//LevelParser lp = new LevelParser();
		Level editLevel = LevelParser.getLevel(path);
		m.setLevel(editLevel);
		app.displayLevelEditor();
		
//		try (Scanner fileScanner = new Scanner(new File(path))){
//			m.parseFile(fileScanner);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		

		
	}

}

