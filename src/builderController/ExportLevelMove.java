package builderController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import builderController.IMove;
import builderEntity.Board;
import builderEntity.BoardElt;
import builderEntity.BuilderModel;
import builderEntity.Bullpen;
import builderEntity.Level;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class ExportLevelMove implements IMove {

	BuilderModel model;
	String filePath;
	boolean overwrite = true;
	
	public ExportLevelMove(BuilderModel m, String filePath){
		this.model = m;
		this.filePath = filePath;
	}
	
	public ExportLevelMove(BuilderModel m, String filePath, boolean overwrite){
		this.model = m;
		this.filePath = filePath;
		this.overwrite = overwrite;
	}
	
	@Override
	public boolean doMove() {
		this.writeFile();
		return true;
	}

	@Override
	public boolean undoMove() {
		// This move cannot be undone
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO this is not always true
		return true;
	}
	
	void writeFile(){
		
		// Extract the data that will be written
		Level lvl = model.getLevel();
		BoardElt elts[][] = lvl.getBoard().getBoardElts();
		ArrayList<Integer> tileReferenceNumbers =  lvl.getBullpen().getTileReferenceNumbers();
		String type = lvl.getLevelType();
		int data = lvl.getlevelData();
		
		try {
			File file = new File("src/resources/levels/"+filePath);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			else if(overwrite == true){
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
			bw.write("EndLevel"); 	bw.newLine();
			
			bw.close();
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}