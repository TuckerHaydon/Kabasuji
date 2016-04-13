package playerController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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

public class LoadGame implements ActionListener{
	
	GameModel m;
	KabasujiPlayerApplication app;
	
	public LoadGame(GameModel m, KabasujiPlayerApplication app){
		
		this.m = m;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String path = JOptionPane.showInputDialog("What is the path to the game file?");
		
		try (Scanner fileScanner = new Scanner(new File("path"))){
			parseFile(fileScanner);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void loadInitialLevel(){
		String path = "Games/ExampleGame1";
		
		try (Scanner fileScanner = new Scanner(new File(path))){
			parseFile(fileScanner);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	void parseFile(Scanner fileScanner){
		
		Level lvls[] = new Level[15];
		
		String next;
		int levelNum = 1;
		
		do
		{
			next = fileScanner.next();
			if(next.equals("BeginLevel")){
				Level lvl = parseLevel(fileScanner, levelNum);
				lvl.setIsUnlocked(true);
				lvls[levelNum - 1] = lvl;
			}
			else if(next.equals("EndLevel"))
			{
				levelNum++;
			}
			
		}
		while(!next.equals("EndGame"));
		
		m.setLevels(lvls);
		
	}
	
	Level parseLevel(Scanner fileScanner, int levelNum){
		
		String levelType = fileScanner.next();
		int levelData = Integer.parseInt(fileScanner.next());
		
		int hexominos[] = parseHexominoes(fileScanner);
		BoardElt elts[][] = parseBoardElts(fileScanner);
		
		
		Bullpen bp = new Bullpen(null);
		Board b = new Board(elts);
	
		switch(levelType)
		{
			case "Lightning":
				return new LightningLevel(levelNum, levelData, b, bp);
			case "Puzzle":
				return new PuzzleLevel(levelNum, levelData, b, bp);
			case "Release":
				return new ReleaseLevel(levelNum, b, bp);
			default:
				System.err.println("Invalid level type from parser");
				return null;
		}
	}

	BoardElt[][] parseBoardElts(Scanner fileScanner) {
		BoardElt elts[][] = new BoardElt[12][12];
		
		// Parse the BeginHexomino
		fileScanner.next();
		
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				String input = fileScanner.next();
				BoardElt elt = null;
				
				switch(input.substring(0, 1)){
					// Playable board elt
					case "P":
						// Check if hint
						if(input.length() == 2){ 	elt = new PlayableBoardElt(row, col, true);}
						else{						elt = new PlayableBoardElt(row, col, false);}
						break;
					// Unplayable board elt
					case "U":
						elt = new UnplayableBoardElt(row, col);
						break;
					// Numbered board elt
					case "N":
						// Parse number and color data out
						int num = Integer.parseInt(input.substring(1, 2));
						String c = input.substring(2, 3);
						Color color = null;
						switch(c){
							case "R":
								color = Color.RED;
								break;
							case "B":
								color = Color.BLUE;
								break;
							case "G":
								color = Color.GREEN;
								break;
						}
						// Check if hint
						if(input.length() == 4){	elt = new NumberBoardElt(row, col, true, color, num);}
						else{						elt = new NumberBoardElt(row, col, false, color, num);}
						break;
				}
				elts[row][col] = elt;
			}
		}
		
		// Parse the EndHexomino
		fileScanner.next();
		
		return elts;
	}

	int[] parseHexominoes(Scanner fileScanner) {
		// TODO Auto-generated method stub
		return null;
	}

}
