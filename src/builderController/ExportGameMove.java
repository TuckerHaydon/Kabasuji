package builderController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import builderEntity.BoardElt;
import builderEntity.BuilderModel;
import builderEntity.Level;

public class ExportGameMove implements IMove{
	
	BuilderModel gm;
	String filePath;
	
	ExportGameMove(BuilderModel gm, String filePath){
		this.gm = gm;
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
	public boolean isValid() {
		// TODO to be edited
		return false;
	}
	
	public void writeToFile(){
		int data;
		String type;
		ArrayList<Integer> tileReferenceNumbers;
		BoardElt[][] elts;
		
		// Extract the data that will be written
		Level[] lvl = gm.getGame().getLevels();
		
		elts = lvl[0].getBoard().getBoardElts();
		tileReferenceNumbers =  lvl[0].getBullpen().getTileReferenceNumbers();
		type = lvl[0].getLevelType();
		data = lvl[0].getlevelData();
		
		try {
			File file = new File("src/resources/levels/"+filePath);
			
			// if file doesn't exist, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			else{
				// TODO maybe check to make sure they want to overwrite
				file.delete();
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("BeginGame"); 		bw.newLine();
			bw.write("BeginLevel"); 	bw.newLine();
			bw.write(type);				bw.newLine();
			bw.write(""+data);			bw.newLine();
					
			// Write the hexomino numbers
			bw.write("BeginHexomino"); 	bw.newLine();
			for(Integer i:tileReferenceNumbers){
				bw.write(i+" ");
			}
			bw.write("EndHexomio"); 	bw.newLine();
				
			// Write the board elts
			bw.write("BeginElts");		bw.newLine();
			for(int row = 0; row < 12; row++){
				for(int col = 0; col < 12; col++){
					bw.write(elts[row][col].toString());
				}
				bw.newLine();
			}
			bw.write("EndElts");		bw.newLine();
			bw.write("EndLevel"); 		bw.newLine();
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i=1; i<15; i++){
			elts = lvl[i].getBoard().getBoardElts();
			tileReferenceNumbers =  lvl[i].getBullpen().getTileReferenceNumbers();
			type = lvl[i].getLevelType();
			data = lvl[i].getlevelData();
			writeFile(i, elts, tileReferenceNumbers, type, data);
			//maybe clear all variables before the next run
		}
	}
	
	public void writeFile (int levelNum, BoardElt elts[][], ArrayList<Integer> tileReferenceNumbers,
			String type, int data){
	
		try {
			File file = new File("src/resources/levels/"+filePath);
			
			//with the second argument, "true", it will append to the end of the file
			//if it already exists
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("BeginLevel"); 	bw.newLine();
			bw.write(type);				bw.newLine();
			bw.write(""+data);			bw.newLine();
					
			// Write the hexomino numbers
			bw.write("BeginHexomino"); 	bw.newLine();
			for(Integer i:tileReferenceNumbers){
				bw.write(i+" ");
			}
			bw.write("EndHexomio"); 	bw.newLine();
				
			// Write the board elts
			bw.write("BeginElts");		bw.newLine();
			for(int row = 0; row < 12; row++){
				for(int col = 0; col < 12; col++){
					bw.write(elts[row][col].toString());
				}
				bw.newLine();
			}
			bw.write("EndElts");		bw.newLine();
			bw.write("EndLevel"); 		bw.newLine();
			
			if(levelNum==14){
				bw.write("EndGame");	bw.newLine();
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
