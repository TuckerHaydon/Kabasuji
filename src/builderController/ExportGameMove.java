package builderController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BoardElt;
import builderEntity.BuilderModel;
import builderEntity.Level;

/**
 * This class is responsible for exporting the game to a storage file
 * @author tuckerhaydon
 * @author dgwalder
 *
 */
public class ExportGameMove extends Move{
	
	String filePath;
	
	public ExportGameMove(KabasujiBuilderApplication app, BuilderModel gm, String filePath){
		super(app, gm);
		this.filePath = filePath;
	}
	
	@Override
	public boolean doMove() {
		this.writeToFile();
		return true;
	}

	@Override
	public boolean undoMove() {
		// This move cannot be undone
		return false;
	}

	@Override
	boolean isValid() {
		// TODO to be edited
		return true;
	}
	
	void writeToFile(){
		
		// Extract the levels
		Level[] levels = m.getGame().getLevels();
		
		try {
			File file = new File(filePath);
			
			// if file doesn't exist, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			else{
				file.delete();
				file.createNewFile();
			}

			// Create the filewriter
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			// Write the BeginGame
			bw.write("BeginGame"); 		bw.newLine();
			
			// Write the 15 levels
			for (int i=0; i<15; i++){
				
				// Dont write a null level
				if(levels[i] == null){
					continue;
				}
				
				try{
					writeFile(levels[i], bw);
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}		
			
			// Write the EndGame
			bw.write("EndGame");
			
			// Close the filewriter
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	void writeFile (Level lvl, BufferedWriter bw) throws IOException{
			
		// Extract the data
		BoardElt elts[][] = lvl.getBoard().getBoardElts();
		String type = lvl.getLevelType().substring(0, 1).toUpperCase()+lvl.getLevelType().substring(1);
		int data = lvl.getlevelData();
		ArrayList<Integer> tileReferenceNumbers = lvl.getBullpen().getTileReferenceNumbers();
		
		// Write the BeginLevel
		bw.write("BeginLevel"); 	bw.newLine();
		
		// Write the level type
		bw.write(type);				bw.newLine();
		
		// Write the level data
		bw.write(""+data);			bw.newLine();
				
		// Write the hexomino numbers
		bw.write("BeginHexomino"); 	bw.newLine();
		System.out.println(tileReferenceNumbers.size());
		for(Integer i:tileReferenceNumbers){
			bw.write(i.intValue()+" ");
		}
		bw.newLine();
		bw.write("EndHexomino"); 	bw.newLine();
			
		// Write the board elts
		bw.write("BeginElts");		bw.newLine();
		for(int row = 0; row < 12; row++){
			for(int col = 0; col < 12; col++){
				bw.write(elts[row][col].toString()+" ");
			}
			bw.newLine();
		}
		bw.write("EndElts");		bw.newLine();
		bw.write("EndLevel"); 		bw.newLine();
		
	}

}

