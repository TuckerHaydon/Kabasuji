package builderController;

import javax.swing.JOptionPane;

import builderEntity.BuilderModel;

public class AddLevelToGameMove implements IMove {
	
	BuilderModel m;
	int levelIndex;
	
	public AddLevelToGameMove(BuilderModel m, int levelIndex) {
		this.m = m;
		this.levelIndex = levelIndex;
	}

	@Override
	public boolean doMove() {
		
		String fileName = JOptionPane.showInputDialog("What is the name of the level file?");
		
		String path = "src/resources/levels/"+fileName;
		
		System.out.println(path);
		
		return true;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public boolean undoMove() {
		return false;
	}

}
