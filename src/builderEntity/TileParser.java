package builderEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * Parses a file containing information about the configuration of the Tiles used
 * in Kabasuji game play
 * 
 * @author tuckerhaydon
 * @author dgwalder
 *
 */
public class TileParser {

	/**
	 * Gets the squares that comprise the tiles available for game play.
	 * @param referenceNumber - reference number of the tile
	 * @param t - the corresponding tile
	 * @return - an array of squares that make up a tile
	 */
	public static Square[] getSquares(int referenceNumber, Tile t){
		
		String path = "src/resources/tiles/tiles";
		Square squares[] = new Square[6];
		
		try (Scanner fileScanner = new Scanner(new File(path))){
			squares = parseTile(fileScanner, referenceNumber, t);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return squares;
	}
	
	/**
	 * Parses a file for the all of the tiles available for Kabasuji game play.
	 * @param fileScanner - a scanner that parses a file
	 * @param referenceNumber - reference number of tile
	 * @param t - a tile
	 * @return - the squares that make up a tile.
	 * 
	 * Each tile is composed of an anchor and five squares that branch from that anchor
	 * in various configurations, each with a relative x and y location (declared with respect
	 * to the anchor).
	 */
	static Square[] parseTile(Scanner fileScanner, int referenceNumber, Tile t){
		
		// Move the scanner ahead to the desired tile
		for(int i = 0; i < referenceNumber - 1; i++){
			fileScanner.nextLine();
		}
		
		// Parse the 12 integers into the square array
		Square squares[] = new Square[6];
		for(int i = 0; i < 6; i++){
			int relX = fileScanner.nextInt();
			int relY = fileScanner.nextInt();
			squares[i] = new Square(relX, relY, t);
		}
		
		
		return squares;
	}
	
	
}