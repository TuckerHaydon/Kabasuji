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
import playerEntity.NumberedBoardElt;
import playerEntity.PlayableBoardElt;
import playerEntity.PuzzleLevel;
import playerEntity.ReleaseLevel;
import playerEntity.UnplayableBoardElt;
import playerEntity.Board;
import playerEntity.BoardElt;
import playerEntity.Bullpen;

/**
 * Loads a game into the player application
 * @author tuckerhaydon, jwilder
 *
 */
public class LoadGame implements ActionListener{
	
	GameModel m;
	KabasujiPlayerApplication app;
	
	/**
	 * Constructor for load game
	 * @param m - top level game model
	 * @param app - top level Kabasuji player application
	 */
	public LoadGame(GameModel m, KabasujiPlayerApplication app){
		
		this.m = m;
		this.app = app;
	}

	/**
	 * Handles the series of events for loading a game into the player
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
				
		String chosenGameName = (String) JOptionPane.showInputDialog(null, "Choose a game to load", "Game Loader",
		        JOptionPane.QUESTION_MESSAGE, null, this.getGameNames().toArray(), this.getGameNames().get(0));
		
		this.processAction(chosenGameName);
		
	}
	
	/**
	 * Loads in an existing game using a file path 
	 * @param chosenGameName - name of chosen game (must exist already)
	 */
	void processAction(String chosenGameName){

		// if cancel was hit, do nothing. 
		if(chosenGameName == null){
			return;
		}

		String path = "src/resources/games/"+chosenGameName;
		parseGame(path);
		
		ResetAchievementMove move = new ResetAchievementMove(app, m, m.getAchievements());
		move.execute();
	}
	
	/**
	 * Parses game file for details on the levels and their attributes
	 * @param path - file path
	 */
	void parseGame(String path){
		try (Scanner fileScanner = new Scanner(new File(path))){
			m.parseFile(fileScanner);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Lists all of the available game names
	 * @return - all of possible game names
	 */
	ArrayList<String> getGameNames(){
		File folder = new File("src/resources/games/");
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> gameNames = new ArrayList<>();
		
		// Get all of the levels in the levels directory
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].getName().substring(0, 1).equals(".")) {
				gameNames.add(listOfFiles[i].getName());
		    }
		}
		return gameNames;
	}
	
	

}
