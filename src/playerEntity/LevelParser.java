package playerEntity;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import playerEntity.Level;

/**
 * This class parses a storage file containing level information
 * It is used to when loading a game to the player application
 * @author tuckerhaydon
 *
 */
public class LevelParser {
	
	/**
	 * Parses a text file to find level information 
	 * @param path - file path 
	 * @return - level that has been parsed
	 */
	public static Level getLevel(String path){
		
		Level parsedLevel = null;
		
		try(Scanner fileScanner = new Scanner(new File(path));) {
			parsedLevel = parseFile(fileScanner);
		} catch (Exception e) {
			System.err.println("Error parsing file in LevelParser.");
			e.printStackTrace();
		}
		
		return parsedLevel;
	}
	
	/**
	 * Parses a Kabasuji level text file
	 * @param fileScanner - a filescanner
	 * @return - level that has been parsed
	 */
	static Level parseFile(Scanner fileScanner){
		
		Level parsedLevel = null;
		
		// Scan the BeginLevel
		fileScanner.next();
		
		// Scan data
		String levelType = fileScanner.next();
		int levelData = Integer.parseInt(fileScanner.next());
		
		// Scan the Begin Hexomino
		fileScanner.next();
		
		// Scan the hexominos
		ArrayList<Integer> hexominoReferenceNums = new ArrayList<>();
		String next = fileScanner.next();
		while(!next.equals("EndHexomino")){		
			hexominoReferenceNums.add(Integer.parseInt(next));
			next = fileScanner.next();
		}
		
		// Create the bullpen from the reference numbers
		Bullpen bullpen = new Bullpen(hexominoReferenceNums);
		
		// Scan the BeginElts
		fileScanner.next();
		
		// Scan the elts
		BoardElt elts[][] = new BoardElt[12][12];
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				String input = fileScanner.next();
				
				BoardElt elt = null;
				
				switch(input.substring(0, 1)){
				// Playable board elt
				case "P":
					// Check if hint
					if(input.length() == 2){	elt = new PlayableBoardElt(row, col, true);}
					else {						elt = new PlayableBoardElt(row, col, false);}
					break;
				// NumberedBoardElt
				case "N":{
					// Check if hint
					boolean isHint = (input.length() == 4);
					// Parse the number
					int num = Integer.parseInt(input.substring(1,2));
					// Determine what color it is
					Color c = null;
					switch(input.substring(2, 3)){
					case "R": c = Color.RED;
						break;
					case "B": c = Color.BLUE;
						break;
					case "G": c = Color.GREEN;
						break;
					default:
						System.err.println("Error parsing color in LevelParser.");
						break;
					}
												elt = new NumberedBoardElt(row, col, isHint, c, num);
				}
					break;
				// UnplayableBoardElt
				case "U":						elt = new UnplayableBoardElt(row, col);
					break;
				default:
					System.err.println("Error parsing elt in LevelParser.");
					break;
				}
				elts[row][col] = elt;
				
			}
		}
		
		// Create the board
		Board board = new Board(elts);
		
		// Create the level
		switch(levelType.toLowerCase()){
		case "puzzle":
			parsedLevel = new PuzzleLevel(1, levelData, board, bullpen);
			break;
		case "release":
			parsedLevel = new ReleaseLevel(1, board, bullpen);
			break;
		case "lightning":
			parsedLevel = new LightningLevel(1, levelData, board, bullpen);
			break;
		default:
			System.err.println("Wrong levelType in player LevelParser: "+levelType);
			parsedLevel = null;
		}
		
		
		return parsedLevel;
	}

}
