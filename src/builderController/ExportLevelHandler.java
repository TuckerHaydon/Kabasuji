package builderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import builderBoundary.KabasujiBuilderApplication;
import builderEntity.BuilderModel;

/**
 * ExportLevelHandler class
 * handles the exportLevel action
 * @author tuckerhaydon
 *
 */
public class ExportLevelHandler implements ActionListener {
	
	BuilderModel m;
	String fileName;
	KabasujiBuilderApplication app;
	
	/**
	 * ExportLevelHandler constructor
	 * @param app
	 * @param m
	 */
	public ExportLevelHandler(KabasujiBuilderApplication app, BuilderModel m) {
		this.app = app;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		parseInput();
		processAction();
	}
	
	/**
	 * retrieves the fileName
	 */
	void parseInput(){
		fileName = JOptionPane.showInputDialog("Name the level.");
	}
	
	/**
	 * processes the exportLevel action
	 */
	void processAction(){
		
		// Create an export move and do it
		ExportLevelMove move = new ExportLevelMove(app, m, fileName, false);
		move.execute();
	}

}
