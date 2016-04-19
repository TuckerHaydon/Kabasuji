package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class ExportLevelHandler implements ActionListener {
	
	BuilderModel m;
	
	public ExportLevelHandler(BuilderModel m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Create the filepath
		String path = JOptionPane.showInputDialog("Name the level.");
		
		// Create an export move and do it
		ExportLevelMove move = new ExportLevelMove(m, path);
		
		if(move.isValid()){
			move.doMove();
		}
		
		
	}

}
