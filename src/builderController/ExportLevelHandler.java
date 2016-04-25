package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * 
 * @author tuckerhaydon
 *
 */
public class ExportLevelHandler implements ActionListener {
	
	BuilderModel m;
	String fileName;
	
	public ExportLevelHandler(BuilderModel m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		parseInput();
		processAction();
	}
	
	void parseInput(){
		fileName = JOptionPane.showInputDialog("Name the level.");
	}
	
	void processAction(){
		
		// Create an export move and do it
		ExportLevelMove move = new ExportLevelMove(m, fileName, false);
		move.execute();
	}

}
