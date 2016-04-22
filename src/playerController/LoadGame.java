package playerController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import playerBoundary.KabasujiPlayerApplication;
import playerEntity.GameModel;
import playerEntity.Level;
import playerEntity.LightningLevel;
import playerEntity.NumberBoardElt;
import playerEntity.PlayableBoardElt;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;
import playerEntity.UnplayableBoardElt;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.Bullpen;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class LoadGame implements ActionListener{
	
	GameModel m;
	KabasujiPlayerApplication app;
	
	public LoadGame(GameModel m, KabasujiPlayerApplication app){
		
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		File folder = new File("src/resources/games/");
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> gameNames = new ArrayList<>();
		
		// Get all of the levels in the levels directory
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].getName().substring(0, 1).equals(".")) {
				gameNames.add(listOfFiles[i].getName());
		    }
		}
		
		String chosenGameName = (String) JOptionPane.showInputDialog(null, "Choose a game to load", "Game Loader",
		        JOptionPane.QUESTION_MESSAGE, null, gameNames.toArray(), gameNames.get(0));

		String path = "src/resources/games/"+chosenGameName;
		
		try (Scanner fileScanner = new Scanner(new File(path))){
			m.parseFile(fileScanner);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}
	
	

}
