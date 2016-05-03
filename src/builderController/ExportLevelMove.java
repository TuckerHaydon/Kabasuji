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
 * handles the exportLevelMove 
 * @author tuckerhaydon
 *
 */
public class ExportLevelMove extends Move {

	String fileName;
	boolean isTestLevel;
	
	public ExportLevelMove(KabasujiBuilderApplication app, BuilderModel m, String fileName){
		super(app, m);
		this.fileName = fileName;
		this.isTestLevel = false;
	}
	
	public ExportLevelMove(KabasujiBuilderApplication app, BuilderModel m, String fileName, boolean isTestLevel){
		super(app, m);
		this.fileName = fileName;
		this.isTestLevel = isTestLevel;
	}
	
	@Override
	boolean doMove() {
		this.writeFile();
		return true;
	}

	@Override
	public boolean undoMove() {
		// This move cannot be undone
		return false;
	}

	@Override
	boolean isValid() {
		// TODO this is not always true
		return true;
	}
	
	/**
	 * writes the level to a storage file
	 */
	void writeFile(){
		
		// Extract the data that will be written
		Level lvl = m.getLevel();
		BoardElt elts[][] = lvl.getBoard().getBoardElts();
		ArrayList<Integer> tileReferenceNumbers =  lvl.getBullpen().getTileReferenceNumbers();
		String type = lvl.getLevelType();
		int data = lvl.getlevelData();
		
		String filePath = this.getFilePath(type);
		
		try {
			File file = new File(filePath);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			else {
				// TODO maybe check to make sure they want to overwrite
				file.delete();
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("BeginLevel"); 	bw.newLine();
			bw.write(type);				bw.newLine();
			bw.write(""+data);			bw.newLine();
			
			// Write the hexomino numbers
			bw.write("BeginHexomino"); 	bw.newLine();
			for(Integer i:tileReferenceNumbers){
				bw.write(i+" ");
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
			
			bw.close();
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * determines which level type resource folder to export the level to
	 * @param levelType
	 * @return the correct file path
	 */
	String getFilePath(String levelType) {
		
		// If it is a test level, export to the test directory
		if(this.isTestLevel){
			return "src/resources/levels/test/"+fileName;
		}
		
		// If it is not a test level, determine which directory to export the file to
		switch(levelType.toLowerCase()){
		case "puzzle":
			return "src/resources/levels/puzzle/"+fileName;
		case "release":
			return "src/resources/levels/release/"+fileName;
		case "lightning":
			return "src/resources/levels/lightning/"+fileName;
		default:
			System.err.println("Wrong level type in ExportLevelMove: "+levelType);
			return null;
		}
	}

}