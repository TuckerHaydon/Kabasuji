package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import builderEntity.BuilderModel;

public class ExportGameHandler implements ActionListener{
	BuilderModel bm;

	ExportGameHandler(BuilderModel bm){
		this.bm = bm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		// Create the filepath
		String path = JOptionPane.showInputDialog("Name the level.");
				
		// Create an export move and do it
		ExportGameMove move = new ExportGameMove(bm, path);
				
		if(move.isValid()){
			move.doMove();
		}
	}
}
